package ru.bpr.onlinestore.portal.offers.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.offers.models.CredentialsModel;
import ru.bpr.onlinestore.portal.offers.models.ResponseModel;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    @RequestMapping(value = "/signIn", method = RequestMethod.PUT)
    public ResponseModel signIn(@RequestBody CredentialsModel credentials)
    {
        return new ResponseModel(true);
    }
}
