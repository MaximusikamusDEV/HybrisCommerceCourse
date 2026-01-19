package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.constants.QuestionsControllerConstants;
import org.training.model.QuestionsCMSComponentModel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller("QuestionsCMSComponentController")
@RequestMapping(value = QuestionsControllerConstants.Actions.Cms.QuestionsCMSComponent)
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
    @Resource
    private ProductFacade productFacade;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        ProductData productData = (ProductData) request.getAttribute("product");

        if (productData != null) {
            productData.setQuestions(
                    productFacade.getProductForCodeAndOptions(
                            productData.getCode(), List.of(ProductOption.QUESTIONS)
                    ).getQuestions()
            );
        }

        if (productData.getQuestions() != null) {
            int limit = Optional.ofNullable(component.getNumberOfQuestionsToShow()).orElse(3);
            model.addAttribute("questions",
                    productData.getQuestions().stream().limit(limit).toList());
        }

        model.addAttribute("fontSize", component.getFontSize());
    }
}
