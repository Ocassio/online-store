package ru.bpr.onlinestore.portal.services.loading;

import ru.bpr.onlinestore.portal.services.models.User;

import java.math.BigInteger;
import java.util.List;

public interface UserOperationService
{
    List<User> loadUsers();

    User loadById(BigInteger id);

    User loadByPasswordAndEmail(String email, String password);

    void add(User user);

    void update(User user);

    void delete(BigInteger id);

}
