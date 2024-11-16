package org.example.walletmanagement.Service;


import org.example.walletmanagement.Entity.Category;
import org.example.walletmanagement.Repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public void save(Category category){
        categoryRepository.save(category);
    }
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
}
