package ru.bpr.onlinestore.portal.services.loading;

import ru.bpr.onlinestore.portal.services.models.Category;

import java.lang.Object;import java.util.List;

public interface CategoryLoadingService
{
    List<Category> loadCategories();

    Object loadCategoryById(int id);
}
