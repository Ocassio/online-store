package ru.bpr.onlinestore.portal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/offers")
public class OffersController
{
    @ResponseBody
    @RequestMapping("sayHello")
    public String sayHello(@RequestParam("name") String name)
    {
        return "Hello " + name;
    }
}
