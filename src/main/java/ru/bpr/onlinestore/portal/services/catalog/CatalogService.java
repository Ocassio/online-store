package ru.bpr.onlinestore.portal.services.catalog;

import ru.bpr.onlinestore.portal.offers.models.CategoryViewModel;
import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;

import java.util.List;

public interface CatalogService
{
    List<OfferViewModel> getOffers();
    List<CategoryViewModel> getCategories();
    OfferViewModel getOffer(String offerId);
}
