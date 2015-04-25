package ru.bpr.onlinestore.portal.services.loading;

import ru.bpr.onlinestore.portal.services.models.Category;

import java.math.BigInteger;
import java.util.List;

public interface CategoryOperationService
{
    List<Category> loadCategories();

    Category loadById(BigInteger id);

    void add(Category category);

    void update(Category category);

    void delete(Category category);
}
