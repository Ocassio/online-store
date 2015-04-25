package ru.bpr.onlinestore.portal.services.loading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bpr.onlinestore.portal.services.models.Category;

import java.lang.Override;
import java.math.BigInteger;
import java.util.List;

public class CategoryOperationServiceImpl implements CategoryOperationService
{
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> loadCategories()
    {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Category").list();
    }

    @Override
    public Category loadById(BigInteger id)
    {
        Session session = sessionFactory.getCurrentSession();
        return (Category)session.load(Category.class, id);
    }

    @Override
    public void add(Category category)
    {
        Session session = sessionFactory.getCurrentSession();
        session.save(category);
    }

    @Override
    public void update(Category category)
    {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }

    @Override
    public void delete(Category category)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(category);
    }
}
