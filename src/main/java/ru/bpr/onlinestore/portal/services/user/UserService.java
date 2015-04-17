package ru.bpr.onlinestore.portal.services.user;

import ru.bpr.onlinestore.portal.services.models.User;

import java.math.BigInteger;

public interface UserService
{
    User getUser(BigInteger id);
    User getUser(String email, String password);
    void addUser(String email, String password, String name, String surname, String address);
    void updateUser(User user);
    void deleteUser(BigInteger id);
}
