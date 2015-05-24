package ru.bpr.onlinestore.portal.services.loading;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.bpr.onlinestore.portal.services.models.Category;

import java.math.BigInteger;
import java.util.List;

@Transactional
public class CategoryOperationServiceImpl implements CategoryOperationService
{
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> loadCategories()
    {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Category").list();
    }

    @Override
    public Category loadById(BigInteger id)
    {
        Session session = sessionFactory.openSession();
        return (Category)session.load(Category.class, id);
    }

    @Override
    public void add(Category category)
    {
        Session session = sessionFactory.openSession();
        session.save(category);
    }

    @Override
    public void update(Category category)
    {
        Session session = sessionFactory.openSession();
        session.update(category);
    }

    @Override
    public void delete(Category category)
    {
        Session session = sessionFactory.openSession();
        session.delete(category);
    }
}
