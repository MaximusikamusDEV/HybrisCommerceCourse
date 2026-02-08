package org.training.daos;

import org.training.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionDao {
    List<QuestionModel> getQuestions();
    List<QuestionModel> getQuestionsAfterDate(Date date);
}
