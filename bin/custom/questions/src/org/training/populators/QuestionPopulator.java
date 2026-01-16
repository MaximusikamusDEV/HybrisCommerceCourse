package org.training.populators;

import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;
import org.training.model.QuestionModel;
import questions.data.QuestionData;

import java.util.Optional;

public class QuestionPopulator implements Populator<QuestionModel, QuestionData> {
    @Override
    public void populate(QuestionModel questionModel, QuestionData questionData) throws ConversionException {
        questionData.setQuestion(questionModel.getQuestion());
        questionData.setQuestionCustomer(questionModel.getQuestionCustomer().getName());
        questionData.setAnswer(
                Optional.ofNullable(
                                questionModel.getAnswer())
                        .orElse("")
        );

        if (questionModel.getAnswerCustomer() != null) {
            questionData.setAnswerCustomer(
                    Optional.ofNullable(
                                    questionModel.getAnswerCustomer().getName())
                            .orElse("")
            );
        }
    }
}
