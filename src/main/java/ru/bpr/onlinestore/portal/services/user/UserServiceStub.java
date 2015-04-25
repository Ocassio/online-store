package ru.bpr.onlinestore.portal.services.user;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.bpr.onlinestore.portal.services.models.User;

import java.math.BigInteger;

@Service
public class UserServiceStub implements UserService
{
    public User getUser(BigInteger id)
    {
        return null;
    }

    public User getUser(String email, String password)
    {
        if (StringUtils.isEmpty(email))
        {
            throw new IllegalArgumentException("Email can't be empty");
        }
        if (StringUtils.isEmpty(password))
        {
            throw new IllegalArgumentException("Password can't be empty");
        }

        User user = new User();
        user.setId(BigInteger.ONE);
        user.setEmail(email);
        user.setPassword(password);
        user.setName("John");
        user.setSurname("Smith");
        user.setAddress("London");

        return user;
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
