package org.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.training.converters.QuestionConverter;
import org.training.model.QuestionModel;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductQuestionPopulator implements Populator<ProductModel, ProductData> {
    private QuestionConverter questionConverter;

    @Override
    public void populate(ProductModel productModel, ProductData productData) throws ConversionException {
        Set<QuestionModel> approvedQuestions = productModel.getQuestions().stream()
                .filter(questionModel -> Boolean.TRUE.equals(questionModel.getApproved())).collect(Collectors.toSet());

        productData.setQuestions(questionConverter.convertAll(approvedQuestions));
    }

    public void setQuestionConverter(QuestionConverter questionConverter) {
        this.questionConverter = questionConverter;
    }
}
