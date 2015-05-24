package ru.bpr.onlinestore.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.models.ResponseModel;
import ru.bpr.onlinestore.portal.models.authentication.CredentialsViewModel;
import ru.bpr.onlinestore.portal.models.authentication.SignUpDataViewModel;
import ru.bpr.onlinestore.portal.services.models.User;
import ru.bpr.onlinestore.portal.services.user.UserService;
import ru.bpr.onlinestore.portal.sessionbeans.UserHolder;

@RestController
@RequestMapping("/auth")
public class AuthenticationController
{
    @Autowired
    private UserController userController;

    @Autowired
    private UserHolder userHolder;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signIn", method = RequestMethod.PUT)
    public ResponseModel signIn(@RequestBody CredentialsViewModel credentials)
    {
        return signIn(credentials.getEmail(), credentials.getPassword());
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.PUT)
    public ResponseModel signUp(@RequestBody SignUpDataViewModel signUpData)
    {
        ResponseModel response;
        try
        {
            userService.addUser(signUpData.getEmail(), signUpData.getPassword(), signUpData.getName(),
                    signUpData.getSurname(), signUpData.getAddress());

            response = signIn(signUpData.getEmail(), signUpData.getPassword());
        }
        catch (Exception e)
        {
            response = new ResponseModel(false, e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

    @RequestMapping("/signOut")
    public void signOut()
    {
        userHolder.setUser(null);
    }

    private ResponseModel signIn(String email, String password)
    {
        User user = userService.getUser(email, password);
        userHolder.setUser(user);

        try
        {
            return new ResponseModel(true, userController.getCurrentUser());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new ResponseModel(false, e.getMessage());
        }

    }
}
