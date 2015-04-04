package ru.bpr.onlinestore.portal.offers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bpr.onlinestore.portal.offers.models.CategoryViewModel;
import ru.bpr.onlinestore.portal.services.catalog.CatalogService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController
{
    @Autowired
    private CatalogService catalogService;

    @RequestMapping("/getAll")
    public List<CategoryViewModel> getCatgories()
    {
        return catalogService.getCategories();
    }
}
