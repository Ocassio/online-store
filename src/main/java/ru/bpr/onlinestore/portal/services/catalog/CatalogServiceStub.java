package ru.bpr.onlinestore.portal.services.catalog;

import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CatalogServiceStub implements CatalogService
{
    private List<OfferViewModel> offers;
    private List<CategoryViewModel> categories;

    public CatalogServiceStub()
    {
        offers = generateOffers();
        categories = generateCategories();
    }

    public List<OfferViewModel> getOffers()
    {
        return offers;
    }

    public List<CategoryViewModel> getCategories()
    {
        return categories;
    }

    public OfferViewModel getOffer(String offerId)
    {
        return offers.get(Integer.parseInt(offerId));
    }

    private List<OfferViewModel> generateOffers()
    {
        Random random = new Random();
        List<OfferViewModel> offers = new ArrayList<>();
        int countOffers = 20;
        for (int i = 1; i < countOffers; i++)
        {
            offers.add(new OfferViewModel("" + i, "Offer " + i, Integer.toString(random.nextInt(5) + 1), "Offer " + i + " description", Integer.toString(random.nextInt(30000)), Integer.toString(random.nextInt(5) + 1)));
        }

        return offers;
    }

    private List<CategoryViewModel> generateCategories()
    {
        List<CategoryViewModel> categories = new ArrayList<CategoryViewModel>();

        categories.add(new CategoryViewModel("1", "Apps"));
        categories.add(new CategoryViewModel("2", "Games"));
        categories.add(new CategoryViewModel("3", "Movies"));
        categories.add(new CategoryViewModel("4", "Books"));
        categories.add(new CategoryViewModel("5", "Newspapers"));

        return categories;
    }
}
