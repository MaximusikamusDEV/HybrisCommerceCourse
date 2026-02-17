package org.training.controllers.cms;

import de.hybris.platform.addonsupport.controllers.cms.AbstractCMSAddOnComponentController;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.product.ProductOption;
import de.hybris.platform.commercefacades.product.data.ProductData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.training.constants.QuestionsControllerConstants;
import org.training.model.WarrantyCMSComponentModel;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller("WarrantyCMSComponentController")
@RequestMapping(value = QuestionsControllerConstants.Actions.Cms.WarrantyCMSComponent)
public class WarrantyCMSComponentController extends AbstractCMSAddOnComponentController<WarrantyCMSComponentModel> {
    @Resource
    private ProductFacade productFacade;

    @Override
    protected void fillModel(HttpServletRequest request, Model model, WarrantyCMSComponentModel component) {
        ProductData productData = (ProductData) request.getAttribute("product");

        if (productData != null) {
            productData.setWarrantyYears(
                    productFacade.getProductForCodeAndOptions(
                            productData.getCode(), List.of(ProductOption.QUESTIONS)
                    ).getWarrantyYears()
            );

            model.addAttribute("warrantyYears",
                    Optional.ofNullable(productData.getWarrantyYears()).orElse(0));
        }
    }
}
