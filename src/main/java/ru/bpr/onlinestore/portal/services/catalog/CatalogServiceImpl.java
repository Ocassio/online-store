package ru.bpr.onlinestore.portal.services.catalog;

import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
//@Transactional
public class CatalogServiceImpl implements CatalogService
{
    /*@Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;*/
    List<OfferViewModel> offers;
    public List<OfferViewModel> getOffers()
    {
        //categories();
        offers = new ArrayList<OfferViewModel>();
        offers.add(new OfferViewModel("3", "Offer 1", "1", "Offer 1 description", "$1000", "4"));
        offers.add(new OfferViewModel("2", "Offer 2", "2", "Offer 2 description", "$2000", "3"));

        return offers;
    }

    public List<CategoryViewModel> getCategories()
    {
        return new ArrayList<CategoryViewModel>();
    }

    @Override
    public OfferViewModel getOffer(String offerId) {
        return offers.get(Integer.parseInt(offerId));
    }

    /*private List<Category> categories()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Category");
        return query.list();
    }*/
}
