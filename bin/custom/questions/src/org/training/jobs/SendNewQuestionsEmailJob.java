package org.training.jobs;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.servicelayer.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.model.NewQuestionsEmailCronJobModel;
import org.training.model.NewQuestionsEmailProcessModel;
import org.training.services.QuestionService;

import java.util.Date;
import java.util.Optional;

public class SendNewQuestionsEmailJob extends AbstractJobPerformable<NewQuestionsEmailCronJobModel> {
    private QuestionService questionService;
    private ModelService modelService;
    private BusinessProcessService businessProcessService;
    private UserService userService;

    @Override
    public PerformResult perform(NewQuestionsEmailCronJobModel cronJobModel) {
        NewQuestionsEmailProcessModel process;

        process = initProcessModel(cronJobModel);

        businessProcessService.startProcess(process);

        cronJobModel.setLastExecutionTime(new Date());
        modelService.save(cronJobModel);
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private NewQuestionsEmailProcessModel initProcessModel(NewQuestionsEmailCronJobModel cronJobModel) {
        NewQuestionsEmailProcessModel emailProcessModel = businessProcessService.createProcess(
                "newQuestionsEmailProcess-" + System.currentTimeMillis(),
                "newQuestionsEmailProcess");

        setQuestionsBeforeDate(cronJobModel, emailProcessModel);
        emailProcessModel.setSite(cronJobModel.getBaseSite());
        emailProcessModel.setLanguage(cronJobModel.getLanguage());
        emailProcessModel.setCustomer((CustomerModel) userService.getUserForUID(cronJobModel.getCustomerEmail()));
        emailProcessModel.setStore(cronJobModel.getBaseStore());

        return emailProcessModel;
    }

    private void setQuestionsBeforeDate(NewQuestionsEmailCronJobModel cronJobModel, NewQuestionsEmailProcessModel
            emailProcessModel) {
        Optional<Date> lastExecutionTime = Optional.ofNullable(cronJobModel.getLastExecutionTime());

        lastExecutionTime.ifPresentOrElse(
                value -> {
                    emailProcessModel.setQuestionList(questionService.getQuestionsAfterDate(value));
                }, () -> {
                    emailProcessModel.setQuestionList(questionService.getQuestions());
                }
        );
    }

    @Autowired
    public void setModelService(ModelService modelService) {
        this.modelService = modelService;
    }

    @Autowired
    public void setBusinessProcessService(BusinessProcessService businessProcessService) {
        this.businessProcessService = businessProcessService;
    }

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
