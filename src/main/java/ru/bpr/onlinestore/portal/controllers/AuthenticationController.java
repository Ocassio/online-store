package ru.bpr.onlinestore.portal.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.models.ResponseModel;
import ru.bpr.onlinestore.portal.models.authentication.CredentialsViewModel;
import ru.bpr.onlinestore.portal.models.authentication.SignUpDataViewModel;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    @RequestMapping(value = "/signIn", method = RequestMethod.PUT)
    public ResponseModel signIn(@RequestBody CredentialsViewModel credentials)
    {
        return new ResponseModel(true);
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.PUT)
    public ResponseModel signUp(@RequestBody SignUpDataViewModel signUpData)
    {
        return new ResponseModel(true);
    }
}
