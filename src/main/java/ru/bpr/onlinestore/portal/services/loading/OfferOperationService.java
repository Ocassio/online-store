package ru.bpr.onlinestore.portal.services.loading;

import ru.bpr.onlinestore.portal.services.models.Offer;

import java.math.BigInteger;
import java.util.List;

public interface OfferOperationService
{
    List<Offer> loadOffers();

    Offer loadById(BigInteger id);

    void add(Offer offer);

    void update(Offer offer);

    void delete(Offer offer);
}
