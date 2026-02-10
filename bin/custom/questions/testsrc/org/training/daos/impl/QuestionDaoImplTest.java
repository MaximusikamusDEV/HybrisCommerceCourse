package org.training.daos.impl;

import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.training.model.QuestionModel;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@UnitTest
@RunWith(MockitoJUnitRunner.class)
public class QuestionDaoImplTest {
    @Mock
    private FlexibleSearchService flexibleSearchService;
    @InjectMocks
    private QuestionDaoImpl questionDao;

    private List<QuestionModel> questionModels;
    private QuestionModel questionModel;

    @Before
    public void setUp() {
        questionModel = mock(QuestionModel.class);
        questionModels = Arrays.asList(questionModel);
        questionDao.setFlexibleSearchService(flexibleSearchService);
    }

    @Test
    public void testGetQuestions() {
        SearchResult<QuestionModel> searchResult = mock(SearchResult.class);
        when(searchResult.getResult()).thenReturn(questionModels);
        when(flexibleSearchService.<QuestionModel>search(anyString())).thenReturn(searchResult);
        List<QuestionModel> result = questionDao.getQuestions();

        assertNotNull(result);
        assertEquals(questionModels, result);
    }

    @Test
    public void testGetQuestionsAfterDate() {
        Date date = new Date();
        SearchResult<QuestionModel> searchResult = mock(SearchResult.class);

        when(searchResult.getResult()).thenReturn(questionModels);
        when(flexibleSearchService.<QuestionModel>search(anyString(), anyMap())).thenReturn(searchResult);

        List<QuestionModel> result = questionDao.getQuestionsAfterDate(date);

        assertNotNull(result);
        assertEquals(questionModels, result);
    }
}
