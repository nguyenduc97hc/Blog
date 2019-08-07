package com.codegym;

import com.codegym.model.Category;
import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CategoryFormatter implements Formatter<Category> {
    private CategoryService categoryService;
    @Autowired
    public CategoryFormatter(CategoryService provinceService){
        this.categoryService = provinceService;
    }
    @Override
    public Category parse(String text, Locale locale) throws ParseException {
        return categoryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Category object, Locale locale) {
        return  "[" + object.getId() + ", " +object.getName() + "]";
    }
}
