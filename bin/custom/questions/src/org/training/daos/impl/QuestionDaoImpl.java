package org.training.daos.impl;

import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.training.daos.QuestionDao;
import org.training.model.QuestionModel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDaoImpl implements QuestionDao {
    private FlexibleSearchService flexibleSearchService;
    private static final String QUERY_GET_ALL_QUESTIONS = "SELECT {" + QuestionModel.PK + "}" +
            " FROM {" + QuestionModel._TYPECODE + "}";
    private static final String QUERY_GET_QUESTIONS_AFTER_DATE = "SELECT {" + QuestionModel.PK + "}" +
            " FROM {" + QuestionModel._TYPECODE + "} WHERE {" + QuestionModel.CREATIONTIME + "} > ?date";

    @Override
    public List<QuestionModel> getQuestions() {
        return flexibleSearchService.<QuestionModel>search(QUERY_GET_ALL_QUESTIONS).getResult();
    }

    @Override
    public List<QuestionModel> getQuestionsAfterDate(Date date) {
        Map<String, Object> params = new HashMap<>();
        params.put("date", date);
        return flexibleSearchService.<QuestionModel>search(QUERY_GET_QUESTIONS_AFTER_DATE, params).getResult();
    }

    @Autowired
    public void setFlexibleSearchService(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }
}
