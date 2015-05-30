package ru.bpr.onlinestore.portal.services.shoppingcart;

import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;

import java.util.Map;

public interface ShoppingCartService
{
    Map<OfferViewModel, Integer> getEntries();
    void addOffer(String offerId, int count);
    void setOfferCount(String offerId, int count);
    void removeOffer(String offerId);
    void removeOffer(String offerId, int count);
    void clear();
}
