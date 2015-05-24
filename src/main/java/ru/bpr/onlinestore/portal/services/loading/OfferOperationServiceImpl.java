package ru.bpr.onlinestore.portal.services.loading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.bpr.onlinestore.portal.services.models.Offer;

import java.math.BigInteger;
import java.util.List;

@Transactional
public class OfferOperationServiceImpl implements OfferOperationService
{
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Offer> loadOffers()
    {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Offer").list();
    }

    @Override
    public Offer loadById(BigInteger id)
    {
        Session session = sessionFactory.openSession();
        return (Offer)session.load(Offer.class, id);
    }

    @Override
    public void add(Offer offer)
    {
        Session session = sessionFactory.openSession();
        session.save(offer);
    }

    @Override
    public void update(Offer offer)
    {
        Session session = sessionFactory.openSession();
        session.update(offer);
    }

    @Override
    public void delete(Offer offer)
    {
        Session session = sessionFactory.openSession();
        session.delete(offer);
    }
}
