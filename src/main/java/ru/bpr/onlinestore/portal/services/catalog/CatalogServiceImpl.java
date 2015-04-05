package ru.bpr.onlinestore.portal.services.catalog;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bpr.onlinestore.portal.offers.models.CategoryViewModel;
import ru.bpr.onlinestore.portal.offers.models.OfferViewModel;
import ru.bpr.onlinestore.portal.services.models.Category;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService
{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    public List<OfferViewModel> getOffers()
    {
        categories();
        List<OfferViewModel> offers = new ArrayList<OfferViewModel>();
        offers.add(new OfferViewModel("3", "Offer 1", "1", "Offer 1 description", "$1000", "4"));
        offers.add(new OfferViewModel("2", "Offer 2", "2", "Offer 2 description", "$2000", "3"));

        return offers;
    }

    public List<CategoryViewModel> getCategories()
    {
        return new ArrayList<CategoryViewModel>();
    }

    private List<Category> categories()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Category");
        return query.list();
    }
}
