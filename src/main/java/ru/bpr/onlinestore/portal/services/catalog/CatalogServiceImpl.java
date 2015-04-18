package ru.bpr.onlinestore.portal.services.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bpr.onlinestore.portal.converters.CategoryViewModelConverter;
import ru.bpr.onlinestore.portal.converters.OfferViewModelConverter;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.loading.CategoryOperationService;
import ru.bpr.onlinestore.portal.services.loading.OfferOperationService;
import ru.bpr.onlinestore.portal.services.models.Category;
import ru.bpr.onlinestore.portal.services.models.Offer;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService
{
    @Autowired(required = false)
    CategoryOperationService categoryOperationService;
    @Autowired(required = false)
    OfferOperationService offerOperationService;
    @Autowired
    OfferViewModelConverter offerViewModelConverter;
    @Autowired
    CategoryViewModelConverter categoryViewModelConverter;

    public List<OfferViewModel> getOffers()
    {

        List<Offer> offers = offerOperationService.loadOffers();
        List<OfferViewModel> offerViewModels = new ArrayList<OfferViewModel>();
        for(Offer offer : offers)
        {
            OfferViewModel offerViewModel = offerViewModelConverter.convert(offer);
            offerViewModels.add(offerViewModel);
        }
        return offerViewModels;
    }

    public List<CategoryViewModel> getCategories()
    {
        List<Category> categories = categoryOperationService.loadCategories();
        List<CategoryViewModel> categoryViewModels = new ArrayList<CategoryViewModel>();
        for(Category category : categories)
        {
            categoryViewModels.add(categoryViewModelConverter.convert(category));
        }
        return categoryViewModels;
    }

    @Override
    public OfferViewModel getOffer(String offerId)
    {
        Offer offer = offerOperationService.loadById(Integer.valueOf(offerId));
        return offerViewModelConverter.convert(offer);
    }
}
