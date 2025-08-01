package sum25.hsf302.exercise2_se184546.service;

import sum25.hsf302.exercise2_se184546.pojo.Categories;

import java.util.List;

public interface CategoryService {
    Categories save(Categories category);

    List<Categories> findAllCategories();

}
