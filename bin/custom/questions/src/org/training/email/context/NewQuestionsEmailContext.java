package org.training.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import org.training.model.NewQuestionsEmailProcessModel;
import org.training.model.QuestionModel;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewQuestionsEmailContext extends AbstractEmailContext<NewQuestionsEmailProcessModel> {
    private List<QuestionModel> questions;

    @Override
    public void init(NewQuestionsEmailProcessModel businessProcessModel, EmailPageModel emailPageModel) {
        super.init(businessProcessModel, emailPageModel);
        questions = businessProcessModel.getQuestionList();
        Map<ProductModel, List<QuestionModel>> mapQuestionsToProduct = groupQuestionsByProduct();

        put("questionsAmount", questions.size());
        put("questionsByProduct", mapQuestionsToProduct);
    }

    @Override
    protected BaseSiteModel getSite(NewQuestionsEmailProcessModel businessProcessModel) {
        return businessProcessModel.getSite();
    }

    @Override
    protected CustomerModel getCustomer(NewQuestionsEmailProcessModel businessProcessModel) {
        return businessProcessModel.getCustomer();
    }

    @Override
    protected LanguageModel getEmailLanguage(NewQuestionsEmailProcessModel businessProcessModel) {
        return businessProcessModel.getLanguage();
    }

    private Map<ProductModel, List<QuestionModel>> groupQuestionsByProduct() {
        return questions.stream()
                .collect(
                        Collectors.groupingBy(
                                QuestionModel::getProduct,
                                LinkedHashMap::new,
                                Collectors.toList())
                );

    }
}
