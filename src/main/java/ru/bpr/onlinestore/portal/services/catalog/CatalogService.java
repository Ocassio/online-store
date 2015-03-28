package ru.bpr.onlinestore.portal.services.catalog;

import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;

import java.util.List;

public interface CatalogService
{
    List<OfferViewModel> getOffers();
}
