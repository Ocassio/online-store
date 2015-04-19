package ru.bpr.onlinestore.portal.converters;

import org.springframework.core.convert.converter.Converter;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.models.Offer;
import ru.bpr.onlinestore.portal.services.models.Rating;

import java.util.List;

public class OfferViewModelConverter implements Converter<Offer, OfferViewModel>
{
    @Override
    public OfferViewModel convert(Offer source)
    {
        OfferViewModel target = new OfferViewModel();
        target.setId(String.valueOf(source.getId()));
        if (source.getRatings() != null) //TODO check if it really can be null
        {
            target.setRating(Float.toString(calculateRating(source.getRatings())));
        }
        target.setName(source.getName());
        target.setCategoryId(String.valueOf(source.getCategory().getId()));
        target.setPrice(String.valueOf(source.getPrice()));
        target.setDescription(source.getDescription());

        return target;
    }

    private float calculateRating(List<Rating> ratings)
    {
        if (ratings.size() == 0) return 0;

        int sum = 0;
        for(Rating rating : ratings)
        {
            sum += rating.getRating();
        }

        return sum / ratings.size();
    }
}
