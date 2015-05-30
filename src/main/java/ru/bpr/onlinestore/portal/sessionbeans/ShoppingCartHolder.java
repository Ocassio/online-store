package ru.bpr.onlinestore.portal.sessionbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = "globalSession", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCartHolder implements Serializable
{
    //TODO change view model to database model
    //TODO UPDATE complex refactoring of services is needed due to design gap
    private Map<OfferViewModel, Integer> shoppingCartEntries;

    public Map<OfferViewModel, Integer> getShoppingCartEntries()
    {
        if (shoppingCartEntries == null)
        {
            shoppingCartEntries = new HashMap<OfferViewModel, Integer>();
        }
        return shoppingCartEntries;
    }

    public void setShoppingCartEntries(Map<OfferViewModel, Integer> shoppingCartEntries)
    {
        this.shoppingCartEntries = shoppingCartEntries;
    }
}
