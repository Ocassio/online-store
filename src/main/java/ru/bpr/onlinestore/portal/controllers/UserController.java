package ru.bpr.onlinestore.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.models.ResponseModel;
import ru.bpr.onlinestore.portal.models.user.PasswordChangeViewModel;
import ru.bpr.onlinestore.portal.models.user.UserViewModel;
import ru.bpr.onlinestore.portal.services.user.UserService;
import ru.bpr.onlinestore.portal.sessionbeans.UserHolder;

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
    private UserViewModel getCurrentUser()
    {
        return conversionService.convert(userHolder.getUser(), UserViewModel.class);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    private ResponseModel update(UserViewModel updateInfo)
    {
        //TODO update current user profile

        return new ResponseModel(true);
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    private ResponseModel changePassword(PasswordChangeViewModel updateInfo)
    {
        if (!userHolder.getUser().getPassword().equals(updateInfo.getOldPassword()))
        {
            return new ResponseModel(false, "Incorrect password");
        }

        //TODO change current user password

        return new ResponseModel(true);
    }
}
