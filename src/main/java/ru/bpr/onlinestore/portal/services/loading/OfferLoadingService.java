package ru.bpr.onlinestore.portal.services.loading;

import ru.bpr.onlinestore.portal.services.models.Offer;

import java.util.List;

public interface OfferLoadingService
{
    List<Offer> loadOffers();

    Offer loadOfferById(int id);
}
