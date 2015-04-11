package ru.bpr.onlinestore.portal.services.loading;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.bpr.onlinestore.portal.services.models.Category;

import java.lang.Override;import java.util.List;

public class CategoryLoadingServiceImpl implements CategoryLoadingService
{
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    public List<Category> loadCategories()
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category");
        return query.list();
    }

    @Override
    public Category loadCategoryById(int id)
    {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category where id = :id");
        query.setParameter("id", id);
        return (Category) query.list().get(0);
    }
}
