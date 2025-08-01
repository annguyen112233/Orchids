package sum25.hsf302.exercise2_se184546.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sum25.hsf302.exercise2_se184546.pojo.Categories;
import sum25.hsf302.exercise2_se184546.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Categories save(Categories category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Categories> findAllCategories() {
        return categoryRepository.findAll();
    }

}
