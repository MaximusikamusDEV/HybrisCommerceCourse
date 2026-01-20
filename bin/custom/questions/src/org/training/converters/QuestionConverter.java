package org.training.converters;

import de.hybris.platform.converters.impl.AbstractConverter;
import org.training.model.QuestionModel;
import org.training.populators.QuestionPopulator;
import questions.data.QuestionData;

public class QuestionConverter extends AbstractConverter<QuestionModel, QuestionData> {
    private QuestionPopulator questionPopulator;

    @Override
    public void populate(QuestionModel questionModel, QuestionData questionData) {
        questionPopulator.populate(questionModel, questionData);
    }

    public void setQuestionPopulator(QuestionPopulator questionPopulator) {
        this.questionPopulator = questionPopulator;
    }
}
