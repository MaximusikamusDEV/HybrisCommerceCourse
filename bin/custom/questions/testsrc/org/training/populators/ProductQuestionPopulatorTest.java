package org.training.populators;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.core.model.product.ProductModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.training.converters.QuestionConverter;
import org.training.model.QuestionModel;
import questions.data.QuestionData;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class ProductQuestionPopulatorTest {
    @Mock
    private QuestionModel questionModel;
    @Mock
    private ProductModel productModel;
    @Mock
    private QuestionConverter questionConverter;
    @InjectMocks
    private ProductQuestionPopulator populator;
    private ProductData productData;

    @Before
    public void setUp() {
        productData = new ProductData();
    }

    @Test
    public void testPopulate() {
        Set<QuestionModel> questionModels = new HashSet<>();
        questionModels.add(questionModel);

        QuestionData questionData = new QuestionData();
        questionData.setQuestion("que");
        questionData.setAnswer("ans");
        questionData.setQuestionCustomer("nameC");
        questionData.setAnswerCustomer("nameA");

        when(productModel.getQuestions()).thenReturn(questionModels);
        when(questionConverter.convertAll(questionModels)).thenReturn(Collections.singletonList(questionData));

        populator.populate(productModel, productData);

        QuestionData checkQuestionData = productData.getQuestions().stream().findAny().get();

        assertEquals("que", checkQuestionData.getQuestion());
        assertEquals("ans", checkQuestionData.getAnswer());
        assertEquals("nameC", checkQuestionData.getQuestionCustomer());
        assertEquals("nameA", checkQuestionData.getAnswerCustomer());
    }
}
