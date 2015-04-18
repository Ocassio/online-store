package ru.bpr.onlinestore.portal.services.loading;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bpr.onlinestore.portal.services.models.Offer;

import java.lang.Override;import java.util.List;

public class OfferOperationServiceImpl implements OfferOperationService
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
    public Offer loadById(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        return (Offer)session.load(Offer.class, id);
    }

    @Override
    public void add(Offer offer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(offer);
    }

    @Override
    public void update(Offer offer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(offer);
    }

    @Override
    public void delete(Offer offer)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(offer);
    }
}
