package ru.bpr.onlinestore.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.models.UserViewModel;
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
}
