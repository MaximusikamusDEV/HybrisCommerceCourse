package org.training.converters;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.training.model.QuestionModel;
import org.training.populators.QuestionPopulator;
import questions.data.QuestionData;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class QuestionConverterTest {
    @Mock
    private QuestionModel questionModel;
    @Mock
    private CustomerModel questionCustomer;
    @Mock
    private CustomerModel answerCustomer;
    private QuestionData questionData;
    private QuestionConverter questionConverter;

    @Before
    public void setUp() {
        questionConverter = new QuestionConverter();
        QuestionPopulator questionPopulator = new QuestionPopulator();
        questionConverter.setQuestionPopulator(questionPopulator);
        questionData = new QuestionData();
    }

    @Test
    public void testPopulate() {
        when(questionModel.getQuestion()).thenReturn("que");
        when(questionModel.getAnswer()).thenReturn("ans");
        when(questionModel.getQuestionCustomer()).thenReturn(questionCustomer);
        when(questionModel.getAnswerCustomer()).thenReturn(answerCustomer);
        when(questionCustomer.getName()).thenReturn("nameC");
        when(answerCustomer.getName()).thenReturn("nameA");

        questionConverter.populate(questionModel, questionData);

        assertEquals("que", questionData.getQuestion());
        assertEquals("ans", questionData.getAnswer());
        assertEquals("nameC", questionData.getQuestionCustomer());
        assertEquals("nameA", questionData.getAnswerCustomer());
    }
}
