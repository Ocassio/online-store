package ru.bpr.onlinestore.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.catalog.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OffersController
{
    @Autowired
    private CatalogService catalogService;

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
}
