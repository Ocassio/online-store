package ru.bpr.onlinestore.portal.services.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.catalog.CatalogService;
import ru.bpr.onlinestore.portal.sessionbeans.ShoppingCartHolder;

import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService
{
    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ShoppingCartHolder shoppingCartHolder;

    @Override
    public Map<OfferViewModel, Integer> getEntries()
    {
        return shoppingCartHolder.getShoppingCartEntries();
    }

    public void addOffer(String offerId, int count)
    {
        Map.Entry<OfferViewModel, Integer> entry = getEntry(offerId);

        if (entry != null)
        {
            entry.setValue(count);
        }
        else
        {
            OfferViewModel offer = catalogService.getOffer(offerId);
            shoppingCartHolder.getShoppingCartEntries().put(offer, count);
        }
    }

    public void setOfferCount(String offerId, int count)
    {
        Map.Entry<OfferViewModel, Integer> entry = getEntry(offerId);

        if (entry != null)
        {
            OfferViewModel offer = catalogService.getOffer(offerId);
            shoppingCartHolder.getShoppingCartEntries().put(offer, count);
        }
    }

    public void removeOffer(String offerId)
    {
        OfferViewModel offer = catalogService.getOffer(offerId);
        shoppingCartHolder.getShoppingCartEntries().remove(offer);
    }

    public void removeOffer(String offerId, int count)
    {
        Map.Entry<OfferViewModel, Integer> entry = getEntry(offerId);

        if (entry != null)
        {
            OfferViewModel offer = catalogService.getOffer(offerId);
            int oldCount = shoppingCartHolder.getShoppingCartEntries().get(offer);
            if (oldCount <= count)
            {
                shoppingCartHolder.getShoppingCartEntries().remove(offer);
            }
            else
            {
                shoppingCartHolder.getShoppingCartEntries().put(offer, oldCount - count);
            }
        }
    }

    public void clear()
    {
        shoppingCartHolder.getShoppingCartEntries().clear();
    }

    private Map.Entry<OfferViewModel, Integer> getEntry(String offerId)
    {
        for (Map.Entry<OfferViewModel, Integer> entry : shoppingCartHolder.getShoppingCartEntries().entrySet())
        {
            if (entry.getKey().getId().equals(offerId))
            {
                return entry;
            }
        }

        return null;
    }
}
