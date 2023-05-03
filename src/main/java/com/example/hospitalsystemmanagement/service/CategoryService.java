package com.example.hospitalsystemmanagement.service;

import com.example.hospitalsystemmanagement.entity.Category;
import java.util.List;

/**
 * Created by bonda on 18.04.2023 10:53
 *
 * @author bonda
 */
public interface CategoryService {
    public List<Category> findAll();

    public Category findById(Long theId);

    public void save(Category theCategory);

    public void deleteById(Long theId);
}
