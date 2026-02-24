package org.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.training.converters.QuestionConverter;
import org.training.model.QuestionModel;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductWarrantyYearsPopulator implements Populator<ProductModel, ProductData> {
    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setWarrantyYears(productModel.getWarrantyYears());
    }
}
