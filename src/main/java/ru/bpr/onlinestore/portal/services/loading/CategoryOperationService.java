package ru.bpr.onlinestore.portal.services.loading;

import ru.bpr.onlinestore.portal.services.models.Category;
import ru.bpr.onlinestore.portal.services.models.Offer;

import java.lang.Object;import java.util.List;

public interface CategoryOperationService
{
    List<Category> loadCategories();

    Category loadById(int id);

    void add(Category category);

    void update(Category category);

    void delete(Category category);
}
