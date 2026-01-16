package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.constants.QuestionsControllerConstants;
import org.training.model.QuestionsCMSComponentModel;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping(QuestionsControllerConstants.Actions.Cms.ProductQuestionsComponent)
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        ProductData productData = (ProductData) model.getAttribute("product");

        if(productData != null) {
            int limit = Optional.ofNullable(component.getNumberOfQuestionsToShow()).orElse(3);
            model.addAttribute("questions",
                    productData.getQuestions().stream().limit(limit).toList());
        }

        model.addAttribute("fontSize", component.getFontSize());
    }

    @Override
    protected String getView(QuestionsCMSComponentModel component) {
        return "addon:/questions/cms/" + StringUtils.lowerCase(getTypeCode(component));
    }
}
