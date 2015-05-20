package ru.bpr.onlinestore.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.bpr.onlinestore.portal.models.FIleModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.catalog.CatalogService;

import java.io.IOException;
import java.util.Iterator;
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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public OfferViewModel addOffer(@RequestParam("offer") OfferViewModel offer, MultipartHttpServletRequest request)
    {
        Iterator<String> iterator = request.getFileNames();
        while (iterator.hasNext())
        {
            try
            {
                MultipartFile file = request.getFile(iterator.next());

                FIleModel fIleModel = new FIleModel();
                fIleModel.setFileName(file.getOriginalFilename());
                fIleModel.setFileType(file.getContentType());
                fIleModel.setBytes(file.getBytes());

                offer.addImage(fIleModel);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

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
