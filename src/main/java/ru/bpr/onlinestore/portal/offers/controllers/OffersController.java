package ru.bpr.onlinestore.portal.offers.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/offers")
public class OffersController
{
    @RequestMapping("/getAllOffers")
    public List<OfferViewModel> getAllOffers()
    {
        List<OfferViewModel> offers = new ArrayList<OfferViewModel>();
        offers.add(new OfferViewModel("1", "Offer 1", "Offer 1 description", "$1000"));
        offers.add(new OfferViewModel("2", "Offer 2", "Offer 2 description", "$2000"));

        return offers;
    }
}
