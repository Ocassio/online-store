package ru.bpr.onlinestore.portal.converters;


import org.springframework.core.convert.converter.Converter;
import ru.bpr.onlinestore.portal.exception.ConvertModelException;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.models.Offer;
import ru.bpr.onlinestore.portal.services.models.Rating;

import java.util.List;

public class OfferViewModelConverter implements Converter<Offer, OfferViewModel>
{
    @Override
    public OfferViewModel convert(Offer offer)
    {
        if (offer == null)
        {
            throw new ConvertModelException("Error in covert");
        }
        OfferViewModel offerViewModel = new OfferViewModel();
        offerViewModel.setId(String.valueOf(offer.getId()));
        if (offer.getRatings() != null)
        {
            offerViewModel.setRating(calculateRating(offer.getRatings()));
        }
        offerViewModel.setName(offer.getName());
        offerViewModel.setCategoryId(String.valueOf(offer.getCategory().getId()));
        offerViewModel.setPrice(String.valueOf(offer.getPrice()));
        offerViewModel.setDescription(offer.getDescription());
        return offerViewModel;
    }

    private String calculateRating(List<Rating> ratings)
    {
        if (ratings.size() == 0)
        {
            return "0";
        }
        int sum = 0;
        for(int i = 0; i < ratings.size(); i++)
        {
            sum += ratings.get(i).getRating();
        }
        return String.valueOf(sum / ratings.size());
    }
}
