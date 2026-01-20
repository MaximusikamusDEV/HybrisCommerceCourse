package org.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.training.converters.QuestionConverter;

public class ProductQuestionPopulator implements Populator<ProductModel, ProductData> {
    private QuestionConverter questionConverter;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        productData.setQuestions(questionConverter.convertAll(productModel.getQuestions()));
    }

    public void setQuestionConverter(QuestionConverter questionConverter) {
        this.questionConverter = questionConverter;
    }
}
