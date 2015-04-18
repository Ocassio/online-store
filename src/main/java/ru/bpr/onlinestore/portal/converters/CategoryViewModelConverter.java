package ru.bpr.onlinestore.portal.converters;

import org.springframework.core.convert.converter.Converter;
import ru.bpr.onlinestore.portal.exception.ConvertModelException;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.services.models.Category;

public class CategoryViewModelConverter implements Converter<Category, CategoryViewModel>
{

    @Override
    public CategoryViewModel convert(Category category)
    {
        if (category == null)
        {
            throw new ConvertModelException("Error in covert");
        }
        CategoryViewModel categoryViewModel = new CategoryViewModel();
        categoryViewModel.setId(String.valueOf(category.getId()));
        categoryViewModel.setName(category.getName());
        return categoryViewModel;
    }
}
