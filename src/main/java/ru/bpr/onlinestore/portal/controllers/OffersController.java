package ru.bpr.onlinestore.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/offers")
public class OffersController
{
    @ResponseBody
    @RequestMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name)
    {
        return "Hello " + name;
    }
}
