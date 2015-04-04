package ru.bpr.onlinestore.portal.services.catalog;

import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.offers.models.CategoryViewModel;
import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceStub implements CatalogService
{
    public List<OfferViewModel> getOffers()
    {
        List<OfferViewModel> offers = new ArrayList<OfferViewModel>();
        offers.add(new OfferViewModel("1", "Offer 1", "1", "Offer 1 description", "$1000", "5"));
        offers.add(new OfferViewModel("2", "Offer 2", "2", "Offer 2 description", "$2000", "5"));
        offers.add(new OfferViewModel("3", "Offer 3", "1", "Offer 3 description", "$3000", "2"));
        offers.add(new OfferViewModel("2", "Offer 2", "3", "Offer 2 description", "$2000", "5"));
        offers.add(new OfferViewModel("3", "Offer 3", "1", "Offer 3 description", "$3000", "1"));
        offers.add(new OfferViewModel("2", "Offer 2", "4", "Offer 2 description", "$2000", "5"));
        offers.add(new OfferViewModel("3", "Offer 3", "4", "Offer 3 description", "$3000", "4"));
        offers.add(new OfferViewModel("2", "Offer 2", "1", "Offer 2 description", "$2000", "3"));
        offers.add(new OfferViewModel("3", "Offer 3", "1", "Offer 3 description", "$3000", "3"));
        offers.add(new OfferViewModel("2", "Offer 2", "5", "Offer 2 description", "$2000", "3"));
        offers.add(new OfferViewModel("3", "Offer 3", "2", "Offer 3 description", "$3000", "5"));
        offers.add(new OfferViewModel("2", "Offer 2", "5", "Offer 2 description", "$2000", "3"));
        offers.add(new OfferViewModel("3", "Offer 3", "3", "Offer 3 description", "$3000", "2"));
        offers.add(new OfferViewModel("2", "Offer 2", "1", "Offer 2 description", "$2000", "3"));
        offers.add(new OfferViewModel("3", "Offer 3", "4", "Offer 3 description", "$3000", "1"));
        offers.add(new OfferViewModel("2", "Offer 2", "5", "Offer 2 description", "$2000", "3"));
        offers.add(new OfferViewModel("3", "Offer 3", "1", "Offer 3 description", "$3000", "4"));
        offers.add(new OfferViewModel("2", "Offer 2", "2", "Offer 2 description", "$2000", "3"));
        offers.add(new OfferViewModel("3", "Offer 3", "3", "Offer 3 description", "$3000", "2"));

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
}
