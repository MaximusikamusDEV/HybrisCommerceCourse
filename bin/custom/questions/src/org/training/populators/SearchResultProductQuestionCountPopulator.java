package org.training.populators;

import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.search.converters.populator.SearchResultProductPopulator;
import de.hybris.platform.commerceservices.search.resultdata.SearchResultValueData;
import org.apache.log4j.Logger;

public class SearchResultProductQuestionCountPopulator extends SearchResultProductPopulator {
    private static final Logger LOG = Logger.getLogger(SearchResultProductQuestionCountPopulator.class);
    @Override
    public void populate(SearchResultValueData source, ProductData target) {
        super.populate(source, target);
        Integer questionCount = this.<Integer> getValue(source, "questionCount");
        target.setQuestionCount(questionCount);
    }
}
