package ru.bpr.onlinestore.portal.services.shoppingcart;

public interface ShoppingCartService
{
    void addOffer(String offerId, int count);
    void setOfferCount(String offerId, int count);
    void removeOffer(String offerId);
    void removeOffer(String offerId, int count);
}
