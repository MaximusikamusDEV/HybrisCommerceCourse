package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.constants.QuestionsControllerConstants;
import org.training.model.QuestionsCMSComponentModel;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping(QuestionsControllerConstants.Actions.Cms.ProductQuestionsComponent)
public class QuestionsCMSComponentController extends AbstractCMSAddOnComponentController<QuestionsCMSComponentModel> {
    private static final Logger LOG = Logger.getLogger(QuestionsCMSComponentController.class);

    @Override
    protected void fillModel(HttpServletRequest request, Model model, QuestionsCMSComponentModel component) {
        LOG.info("===== QUESTIONS CONTROLLER CALLED =====");

        ProductData productData = (ProductData) model.getAttribute("product");
        LOG.info("ProductData: " + productData);

        if(productData != null) {
            LOG.info("Product code: " + productData.getCode());
            LOG.info("Product questions: " + productData.getQuestions());

            if(productData.getQuestions() != null) {
                int limit = Optional.ofNullable(component.getNumberOfQuestionsToShow()).orElse(3);
                var questions = productData.getQuestions().stream().limit(limit).toList();
                model.addAttribute("questions", questions);
                LOG.info("Questions added to model: " + questions.size());
            } else {
                LOG.warn("Questions list is NULL!");
                model.addAttribute("questions", java.util.Collections.emptyList());
            }
        } else {
            LOG.warn("ProductData is NULL!");
            model.addAttribute("questions", java.util.Collections.emptyList());
        }

        model.addAttribute("fontSize", component.getFontSize());
        LOG.info("===== END QUESTIONS CONTROLLER =====");
    }

    @Override
    protected String getView(QuestionsCMSComponentModel component) {
        return "addon:/questions/cms/" + StringUtils.lowerCase(getTypeCode(component));
    }
}
