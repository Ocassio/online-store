package ru.bpr.onlinestore.portal.services.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.loading.CategoryOperationService;
import ru.bpr.onlinestore.portal.services.loading.OfferOperationService;
import ru.bpr.onlinestore.portal.services.models.Category;
import ru.bpr.onlinestore.portal.services.models.Offer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService
{
    @Autowired(required = false)
    private CategoryOperationService categoryOperationService;

    @Autowired(required = false)
    private OfferOperationService offerOperationService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public List<OfferViewModel> getOffers()
    {
        List<Offer> offers = offerOperationService.loadOffers();

        List<OfferViewModel> offerViewModels = new ArrayList<OfferViewModel>();
        for(Offer offer : offers)
        {
            OfferViewModel offerViewModel = conversionService.convert(offer, OfferViewModel.class);
            offerViewModels.add(offerViewModel);
        }

        return offerViewModels;
    }

    @Override
    public List<CategoryViewModel> getCategories()
    {
        List<Category> categories = categoryOperationService.loadCategories();

        List<CategoryViewModel> categoryViewModels = new ArrayList<CategoryViewModel>();
        for(Category category : categories)
        {
            categoryViewModels.add(conversionService.convert(category, CategoryViewModel.class));
        }

        return categoryViewModels;
    }

    @Override
    public OfferViewModel getOffer(String offerId)
    {
        Offer offer = offerOperationService.loadById(new BigInteger(offerId));
        return conversionService.convert(offer, OfferViewModel.class);
    }

    @Override
    public OfferViewModel addOffer(OfferViewModel offer)
    {
        return null;
    }

    @Override
    public void editOffer(OfferViewModel offer)
    {

    }

    @Override
    public void deleteOffer(String offerId)
    {

    }
}
