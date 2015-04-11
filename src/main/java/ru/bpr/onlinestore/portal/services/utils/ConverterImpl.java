package ru.bpr.onlinestore.portal.services.utils;

import ru.bpr.onlinestore.portal.exception.ConvertModelException;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.models.Category;
import ru.bpr.onlinestore.portal.services.models.Offer;

public class ConverterImpl implements Converter
{
    @Override
    @SuppressWarnings("unchecked")
    public <T> T covert(Object source, Class<T> expected)
    {
        if (source == null)
        {
            throw new ConvertModelException("source is null");
        }
        if (expected == null)
        {
            throw new ConvertModelException("expected result is null");
        }
        if (source instanceof Category)
        {
            if (CategoryViewModel.class.equals(expected))
            {
                Category category = (Category) source;
                CategoryViewModel categoryViewModel = new CategoryViewModel();
                categoryViewModel.setId(String.valueOf(category.getId()));
                categoryViewModel.setName(category.getName());
                return (T) categoryViewModel;
            }
        }
        if (source instanceof Offer)
        {
            if (OfferViewModel.class.equals(expected))
            {
                Offer offer = (Offer)source;
                OfferViewModel offerViewModel = new OfferViewModel();
                offerViewModel.setId(String.valueOf(offer.getId()));
                offerViewModel.setName(offer.getName());
                offerViewModel.setCategoryId(String.valueOf(offer.getCategory().getId()));
                //shit db
                //offerViewModel.setDescription();

            }
        }
        throw new ConvertModelException("Problem in covert Object" + source.getClass());
    }
}
