package ru.bpr.onlinestore.portal.services.loading;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.bpr.onlinestore.portal.services.models.User;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;

@Transactional
public class UserOperationServiceImpl implements UserOperationService
{
    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> loadUsers()
    {
        Session session = sessionFactory.openSession();
        return session.createQuery("From User").list();
    }

    @Override
    public User loadById(BigInteger id)
    {
        Session session = sessionFactory.openSession();
        return (User)session.load(User.class, id);
    }

    @Override
    public User loadByPasswordAndEmail(String email, String password)
    {
        Session session = sessionFactory.openSession();
        Iterator query = session.createQuery("From User u where u.password = :password and (u.email = :email)")
            .setString("password", password)
            .setString("email", email)
            .iterate();
        if (query.hasNext()) return (User)query.next();
        return null;
    }

    @Override
    public void add(User user)
    {
        Session session = sessionFactory.openSession();
        session.save(user);
    }

    @Override
    public void update(User user)
    {
        Session session = sessionFactory.openSession();
        session.update(user);
    }

    @Override
    public void delete(BigInteger id)
    {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("delete from User where User.id = :id");
        query.setBigInteger("id", id);
        query.executeUpdate();
    }
}
