package ru.bpr.onlinestore.portal.converters;

import org.springframework.core.convert.converter.Converter;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.services.models.Category;

public class CategoryViewModelConverter implements Converter<Category, CategoryViewModel>
{

    @Override
    public CategoryViewModel convert(Category source)
    {
        CategoryViewModel target = new CategoryViewModel();

        target.setId(String.valueOf(source.getId()));
        target.setName(source.getName());

        return target;
    }
}
