package ru.bpr.onlinestore.portal.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import ru.bpr.onlinestore.portal.models.FIleModel;
import ru.bpr.onlinestore.portal.models.ResponseModel;
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
    public ResponseModel addOffer(@RequestParam("offer") OfferViewModel offer, MultipartHttpServletRequest request)
    {
        Iterator<String> iterator = request.getFileNames();
        while (iterator.hasNext())
        {
            try
            {
                MultipartFile file = request.getFile(iterator.next());

                FIleModel fileModel = new FIleModel();
                fileModel.setFileName(file.getOriginalFilename());
                fileModel.setFileType(file.getContentType());
                fileModel.setBytes(file.getBytes());

                offer.addImage(fileModel);
            }
            catch (IOException e)
            {
                return new ResponseModel(false, e.getMessage());
            }
        }

        try
        {
            OfferViewModel newOffer = catalogService.addOffer(offer);
            return new ResponseModel(true, newOffer);
        }
        catch (HibernateException e)
        {
            return new ResponseModel(false, e.getMessage());
        }
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
