package ru.bpr.onlinestore.portal.services.user;

import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.services.models.User;

import java.math.BigInteger;

@Service
public class UserServiceImpl implements UserService
{
    public User getUser(BigInteger id)
    {
        return null;
    }

    public User getUser(String email, String password)
    {
        return null;
    }

    public void addUser(String email, String password, String name, String surname, String address)
    {

    }

    public void updateUser(User user)
    {

    }

    public void deleteUser(BigInteger id)
    {

    }
}
