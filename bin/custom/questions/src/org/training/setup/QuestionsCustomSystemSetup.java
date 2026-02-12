package org.training.setup;

import de.hybris.platform.commerceservices.setup.AbstractSystemSetup;
import de.hybris.platform.core.initialization.SystemSetup;
import de.hybris.platform.core.initialization.SystemSetupContext;
import de.hybris.platform.core.initialization.SystemSetupParameter;
import org.training.constants.QuestionsConstants;
import java.util.List;

@SystemSetup(extension = QuestionsConstants.EXTENSIONNAME)
public class QuestionsCustomSystemSetup extends AbstractSystemSetup {
    @SystemSetup(type = SystemSetup.Type.ESSENTIAL)
    public boolean addEssentialData(SystemSetupContext context){
        return true;
    }

    @SystemSetup(type = SystemSetup.Type.PROJECT)
    public boolean addProjectData(SystemSetupContext context) {
        importImpexFile(context, "/impex/projectdata-questions-cms.impex");
        importImpexFile(context,"/impex/projectdata-questions-emailPageTemplate.impex");
        importImpexFile(context,"/impex/projectdata-questions-newQuestionsCronJob.impex");
        importImpexFile(context,"/impex/projectdata-questions-promotionsAndCoupons.impex");
        importImpexFile(context,"/impex/projectdata-questions-questionsValueSolrIndex.impex");
        importImpexFile(context,"/impex/projectdata-specialPriceRow.impex");
        importImpexFile(context,"/impex/questions-fullIndexJobTrigger.impex");
        importImpexFile(context,"/impex/questions-sampleData.impex");
        return true;
    }

    @Override
    public List<SystemSetupParameter> getInitializationOptions() {
        return List.of();
    }
}
