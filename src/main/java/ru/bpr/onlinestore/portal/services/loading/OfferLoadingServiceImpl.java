package ru.bpr.onlinestore.portal.services.loading;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bpr.onlinestore.portal.services.models.Offer;

import java.lang.Override;import java.util.List;

public class OfferLoadingServiceImpl implements OfferLoadingService
{
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    public List<Offer> loadOffers()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Offer");
        return query.list();
    }

    @Override
    public Offer loadOfferById(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Offer where id = :id");
        query.setParameter("id", id);
        return (Offer)query.list().get(0);
    }


}
