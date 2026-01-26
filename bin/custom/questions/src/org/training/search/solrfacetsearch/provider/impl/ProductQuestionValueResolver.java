package org.training.search.solrfacetsearch.provider.impl;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractValueResolver;
import java.util.Collection;
import java.util.Optional;

public class ProductQuestionValueResolver extends AbstractValueResolver<ProductModel, Integer, Object> {
    @Override
    protected Integer loadData(IndexerBatchContext batchContext,
                               Collection<IndexedProperty> indexedProperties,
                               ProductModel model){
        return Optional.ofNullable(model.getQuestions())
                .map(Collection::size)
                .orElse(0);
    }

    @Override
    protected void addFieldValues(InputDocument inputDocument,
                                  IndexerBatchContext indexerBatchContext,
                                  IndexedProperty indexedProperty,
                                  ProductModel productModel,
                                  ValueResolverContext<Integer, Object> valueResolverContext) throws FieldValueProviderException {
        int questionCount = valueResolverContext.getData();

        addFieldValue(
                inputDocument,
                indexerBatchContext,
                indexedProperty,
                questionCount,
                null);
    }
}
