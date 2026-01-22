package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.GenericCMSAddOnComponentController;
import de.hybris.platform.cms2.model.contents.components.AbstractCMSComponentModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.constants.QuestionsControllerConstants;

@Controller("CMSProductListComponentController")
@RequestMapping(value = QuestionsControllerConstants.Actions.Cms.CMSProductListComponent)
public class CMSProductListComponentController extends GenericCMSAddOnComponentController {
    @Override
    protected String getView(AbstractCMSComponentModel component) {
        return QuestionsControllerConstants.ADDON_PREFIX
                + getCmsComponentFolder()
                + "/"
                + QuestionsControllerConstants.Views.Cms.CMSProductListComponentView;
    }
}
