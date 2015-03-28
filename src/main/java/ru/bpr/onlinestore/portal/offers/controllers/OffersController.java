package ru.bpr.onlinestore.portal.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;
import ru.bpr.onlinestore.portal.services.catalog.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OffersController
{
    @Autowired
    private CatalogService catalogService;

    @RequestMapping("/getAllOffers")
    public List<OfferViewModel> getAllOffers()
    {
        return catalogService.getOffers();
    }
}
