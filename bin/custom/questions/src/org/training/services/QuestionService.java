package org.training.services;

import org.training.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionService {
    List<QuestionModel> getQuestions();
    List<QuestionModel> getQuestionsAfterDate(Date date);
}
