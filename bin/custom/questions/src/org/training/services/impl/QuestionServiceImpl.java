package org.training.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.training.daos.QuestionDao;
import org.training.model.QuestionModel;
import org.training.services.QuestionService;
import java.util.Optional;
import java.util.List;
import java.util.Collections;
import java.util.Date;

public class QuestionServiceImpl implements QuestionService {
    private QuestionDao questionDao;

    @Override
    public List<QuestionModel> getQuestions() {
        return Optional.ofNullable(questionDao.getQuestions()).orElse(Collections.emptyList());
    }

    @Override
    public List<QuestionModel> getQuestionsAfterDate(Date date) {
        return Optional.ofNullable(questionDao.getQuestionsAfterDate(date)).orElse(Collections.emptyList());
    }

    @Autowired
    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }
}
