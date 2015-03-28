package ru.bpr.onlinestore.portal.services.catalog;

import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceStub implements CatalogService
{
    public List<OfferViewModel> getOffers()
    {
        List<OfferViewModel> offers = new ArrayList<OfferViewModel>();
        offers.add(new OfferViewModel("1", "Offer 1", "Offer 1 description", "$1000"));
        offers.add(new OfferViewModel("2", "Offer 2", "Offer 2 description", "$2000"));

        return offers;
    }
}
