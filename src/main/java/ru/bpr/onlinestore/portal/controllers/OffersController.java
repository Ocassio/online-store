package ru.bpr.onlinestore.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping("/get/{offerId}")
    public OfferViewModel getOffer(@PathVariable("offerId") String offerId)
    {
        return catalogService.getOffer(offerId);
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public OfferViewModel addOffer(@RequestParam("offer") OfferViewModel offer)
    {
        return catalogService.addOffer(offer);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public void editOffer(@RequestParam("offer") OfferViewModel offer)
    {
        catalogService.editOffer(offer);
    }

    @RequestMapping("/delete/{offerId}")
    public void deleteOffer(@PathVariable("offerId") String offerId)
    {
        catalogService.deleteOffer(offerId);
    }
}
