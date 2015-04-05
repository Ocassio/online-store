package ru.bpr.onlinestore.portal.services.catalog;

import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.offers.models.CategoryViewModel;
import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CatalogServiceStub implements CatalogService
{
    List<OfferViewModel> offers;
    public List<OfferViewModel> getOffers()
    {
        Random random = new Random();
        offers = new ArrayList<OfferViewModel>();
        int countOffers = 20;
        for (int i = 1; i < countOffers; i++)
        {
            offers.add(new OfferViewModel("" + i, "Offer " + i, Integer.toString(random.nextInt(5) + 1), "Offer " + i + " description", "$"+ random.nextInt(30000), Integer.toString(random.nextInt(5) + 1)));
        }

        return offers;
    }

    public List<CategoryViewModel> getCategories()
    {
        List<CategoryViewModel> categories = new ArrayList<CategoryViewModel>();
        categories.add(new CategoryViewModel("1", "Apps"));
        categories.add(new CategoryViewModel("2", "Games"));
        categories.add(new CategoryViewModel("3", "Movies"));
        categories.add(new CategoryViewModel("4", "Books"));
        categories.add(new CategoryViewModel("5", "Newspapers"));

        return categories;
    }

    public OfferViewModel getOffer(String offerId)
    {
        return offers.get(Integer.parseInt(offerId));
    }
}
