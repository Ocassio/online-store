package ru.bpr.onlinestore.portal.services.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.sessionbeans.ShoppingCartHolder;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService
{
    @Autowired
    private ShoppingCartHolder shoppingCartHolder;

    public void addOffer(String offerId, int count)
    {

    }

    public void setOfferCount(String offerId, int count)
    {

    }

    public void removeOffer(String offerId)
    {

    }

    public void removeOffer(String offerId, int count)
    {

    }
}
