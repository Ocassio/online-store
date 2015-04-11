package ru.bpr.onlinestore.portal.services.utils;

import org.junit.Assert;
import org.junit.Test;
import ru.bpr.onlinestore.portal.exception.ConvertModelException;
import ru.bpr.onlinestore.portal.models.catalog.CategoryViewModel;
import ru.bpr.onlinestore.portal.models.catalog.OfferViewModel;
import ru.bpr.onlinestore.portal.services.models.Category;

import static org.junit.Assert.*;

public class ConverterImplTest
{
    @Test
    public void convert_category_in_category_view_model_verify_content()
    {
        Category category = new Category(1, "category1");
        Converter converter = new ConverterImpl();
        CategoryViewModel viewModel = converter.covert(category, CategoryViewModel.class);
        Assert.assertEquals(String.valueOf(category.getId()), viewModel.getId());
        Assert.assertEquals(category.getName(), viewModel.getName());
    }

    @Test(expected = ConvertModelException.class)
    public void convert_category_in_not_valid_object()
    {
        Category category = new Category(1, "category1");
        Converter converter = new ConverterImpl();
        converter.covert(category, OfferViewModel.class);
    }

    @Test(expected = ConvertModelException.class)
    public void convert_object_if_source_is_null()
    {
        Converter converter = new ConverterImpl();
        converter.covert(null, OfferViewModel.class);
    }
    @Test(expected = ConvertModelException.class)
    public void convert_object_if_expected_result_is_null()
    {
        Category category = new Category(1, "category1");
        Converter converter = new ConverterImpl();
        converter.covert(category, null);
    }
}