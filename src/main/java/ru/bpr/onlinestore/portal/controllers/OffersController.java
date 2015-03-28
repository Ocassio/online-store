package ru.bpr.onlinestore.portal.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
public class OffersController
{
    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name)
    {
        return "Hello " + name;
        //[ALSH] test commit
    }
}
