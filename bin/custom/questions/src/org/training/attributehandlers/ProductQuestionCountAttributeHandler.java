package org.training.attributehandlers;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.apache.commons.collections4.CollectionUtils;
import org.training.model.QuestionModel;

import java.util.Set;
import java.util.stream.Collectors;

public class ProductQuestionCountAttributeHandler extends AbstractDynamicAttributeHandler<Integer, ProductModel> {
    @Override
    public Integer get(ProductModel model) {
        Set<QuestionModel> questions = CollectionUtils
                .emptyIfNull(model.getQuestions())
                .stream()
                .filter(QuestionModel::getApproved)
                .collect(Collectors.toSet());

        return questions.size();
    }
}
