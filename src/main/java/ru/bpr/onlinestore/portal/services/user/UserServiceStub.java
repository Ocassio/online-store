package ru.bpr.onlinestore.portal.services.user;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.bpr.onlinestore.portal.services.models.User;

import java.math.BigInteger;

@Service
public class UserServiceStub implements UserService
{
    private User user;

    public UserServiceStub()
    {
        user = generateUser();
    }

    public User getUser(BigInteger id)
    {
        return user;
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

        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public void addUser(String email, String password, String name, String surname, String address)
    {
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
    }

    public void updateUser(User user)
    {
        this.user.setEmail(user.getEmail());
        this.user.setAddress(user.getAddress());
        this.user.setPassword(user.getPassword());
        this.user.setName(user.getName());
        this.user.setSurname(user.getName());
    }

    public void deleteUser(BigInteger id)
    {

    }

    private User generateUser()
    {
        User user = new User();
        user.setId(BigInteger.ONE);
        user.setEmail("test@test.com");
        user.setPassword("123456");
        user.setName("John");
        user.setSurname("Smith");
        user.setAddress("London");

        return user;
    }
}
