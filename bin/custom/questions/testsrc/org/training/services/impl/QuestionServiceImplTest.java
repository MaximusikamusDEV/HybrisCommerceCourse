package org.training.services.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.training.daos.impl.QuestionDaoImpl;
import org.training.model.QuestionModel;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceImplTest {
    @Mock
    private QuestionDaoImpl questionDao;
    @InjectMocks
    private QuestionServiceImpl questionService;

    private List<QuestionModel> questionModels;
    private QuestionModel questionModel;

    @Before
    public void setUp() {
        questionModel = mock(QuestionModel.class);
        questionModels = Arrays.asList(questionModel);
        questionService.setQuestionDao(questionDao);
    }

    @Test
    public void testGetQuestions() {
        when(questionDao.getQuestions()).thenReturn(questionModels);

        List<QuestionModel> result = questionService.getQuestions();

        assertNotNull(result);
        assertEquals(questionModels, result);
    }

    @Test
    public void testGetQuestionsAfterDate() {
        Date date = new Date();

        when(questionDao.getQuestionsAfterDate(date)).thenReturn(questionModels);

        List<QuestionModel> result = questionService.getQuestionsAfterDate(date);

        assertNotNull(result);
        assertEquals(questionModels, result);
    }
}
