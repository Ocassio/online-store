package ru.bpr.onlinestore.portal.services.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bpr.onlinestore.portal.services.loading.UserOperationService;
import ru.bpr.onlinestore.portal.services.models.User;

import java.math.BigInteger;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired(required = false)
    private UserOperationService userOperationService;

    public User getUser(BigInteger id)
    {
        return userOperationService.loadById(id);
    }

    public User getUser(String email, String password)
    {
        return userOperationService.loadByPasswordAndEmail(email, password);
    }

    public void addUser(String email, String password, String name, String surname, String address)
    {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setSurname(surname);
        user.setAddress(address);
        userOperationService.add(user);
    }

    public void updateUser(User user)
    {
        userOperationService.update(user);
    }

    public void deleteUser(BigInteger id)
    {
        userOperationService.delete(id);
    }
}
