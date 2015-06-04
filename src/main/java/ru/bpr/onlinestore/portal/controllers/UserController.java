package ru.bpr.onlinestore.portal.controllers;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.models.ResponseModel;
import ru.bpr.onlinestore.portal.models.user.PasswordChangeViewModel;
import ru.bpr.onlinestore.portal.models.user.UserViewModel;
import ru.bpr.onlinestore.portal.services.models.User;
import ru.bpr.onlinestore.portal.services.user.UserService;
import ru.bpr.onlinestore.portal.sessionbeans.UserHolder;

import java.math.BigInteger;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserHolder userHolder;

    @Autowired
    private UserService userService;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping("/getCurrent")
    public UserViewModel getCurrentUser()
    {
        return conversionService.convert(userHolder.getUser(), UserViewModel.class);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseModel update(@RequestBody UserViewModel updateInfo)
    {
        try
        {
            User user = userService.getUser(new BigInteger(updateInfo.getId()));

            if (user != null)
            {
                user.setEmail(updateInfo.getEmail());
                user.setAddress(updateInfo.getAddress());
                user.setName(updateInfo.getName());
                user.setSurname(updateInfo.getSurname());

                userService.updateUser(user);

                return new ResponseModel(true);
            }

            return new ResponseModel(false, "User doesn't exist");
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return new ResponseModel(false, e.getMessage());
        }
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    public ResponseModel changePassword(@RequestBody PasswordChangeViewModel updateInfo)
    {
        User user = userHolder.getUser();
        if (!user.getPassword().equals(updateInfo.getOldPassword()))
        {
            return new ResponseModel(false, "Incorrect password");
        }

        user.setPassword(updateInfo.getPassword());

        try
        {
            userService.updateUser(user);
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            return new ResponseModel(false, e.getMessage());
        }

        return new ResponseModel(true);
    }
}
