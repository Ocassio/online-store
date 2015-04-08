package ru.bpr.onlinestore.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.catalog.CatalogService;
import ru.bpr.onlinestore.portal.services.shoppingcart.ShoppingCartService;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OffersController
{
    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/get")
    public List<OfferViewModel> getAllOffers()
    {
        return catalogService.getOffers();
    }

    @RequestMapping("/offers/get/{offerId}")
    public OfferViewModel getOffer(@PathVariable("offerId") String offerId)
    {
        return catalogService.getOffer(offerId);
    }

    @RequestMapping(value = "/add/{offerId}", method = RequestMethod.GET)
    public void addOffer(@PathVariable("offerId") String offerId, @RequestParam(value = "count" ,required = false) Integer count)
    {
        if (!StringUtils.isEmpty(offerId))
        {
            int countToAdd = count == null ? 1 : count;
            shoppingCartService.addOffer(offerId, countToAdd);
        }
    }

    @RequestMapping(value = "/setcount/{offerId}", method = RequestMethod.GET)
    public void setOfferCount(@PathVariable("offerId") String offerId, @RequestParam("count") Integer count)
    {
        if (!StringUtils.isEmpty(offerId) && count != null)
        {
            shoppingCartService.setOfferCount(offerId, count);
        }
    }

    @RequestMapping(value = "/remove/{offerId}", method = RequestMethod.GET)
    public void removeOffer(@PathVariable("offerId") String offerId, @RequestParam(value = "count", required = false) Integer count)
    {
        if (!StringUtils.isEmpty(offerId))
        {
            if (count == null)
            {
                shoppingCartService.removeOffer(offerId);
            }
            else
            {
                shoppingCartService.removeOffer(offerId, count);
            }
        }
    }
}
