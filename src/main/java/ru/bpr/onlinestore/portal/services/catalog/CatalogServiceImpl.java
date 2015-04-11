package ru.bpr.onlinestore.portal.services.catalog;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.loading.CategoryLoadingService;
import ru.bpr.onlinestore.portal.services.loading.OfferLoadingService;
import ru.bpr.onlinestore.portal.services.models.Category;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService
{
    @Autowired(required = false)
    CategoryLoadingService categoryLoadingService;
    @Autowired(required = false)
    OfferLoadingService offerLoadingService;

    List<OfferViewModel> offers;

    public List<OfferViewModel> getOffers()
    {
        categoryLoadingService.loadCategories();
        offerLoadingService.loadOffers();
        offers = new ArrayList<OfferViewModel>();
        offers.add(new OfferViewModel("3", "Offer 1", "1", "Offer 1 description", "$1000", "4"));
        offers.add(new OfferViewModel("2", "Offer 2", "2", "Offer 2 description", "$2000", "3"));

        return offers;
    }

    public List<CategoryViewModel> getCategories()
    {
        return new ArrayList<CategoryViewModel>();
    }

    @Override
    public OfferViewModel getOffer(String offerId)
    {
        return offers.get(Integer.parseInt(offerId));
    }
}
