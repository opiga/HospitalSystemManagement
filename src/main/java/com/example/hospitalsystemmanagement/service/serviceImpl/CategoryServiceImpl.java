package com.example.hospitalsystemmanagement.service.serviceImpl;

import com.example.hospitalsystemmanagement.repository.CategoryRepository;
import com.example.hospitalsystemmanagement.entity.Category;
import com.example.hospitalsystemmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by bonda on 18.04.2023 10:54
 *
 * @author bonda
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository theCategoryRepository) {
        categoryRepository = theCategoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long theId) {
        Optional<Category> result = categoryRepository.findById(theId);
        Category theCategory = null;
        if (result.isPresent()) {
            theCategory = result.get();
        }
        else {
            throw new RuntimeException("Did not find category id - " + theId);
        }
        return theCategory;
    }

    @Override
    public void save(Category theCategory) {
        categoryRepository.save(theCategory);
    }

    @Override
    public void deleteById(Long theId) {
        categoryRepository.deleteById(theId);
    }
}