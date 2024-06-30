package com.project.BlogApplication.Service;

import java.util.List;

import com.project.BlogApplication.Dto.CategoryDto;

public interface CategoryService {
	CategoryDto addCategory(CategoryDto category);
	void deleteCategoryById(int id);
	CategoryDto getCategoryById(int id);
	CategoryDto updateCategory(CategoryDto categoryDto,int id);
	List<CategoryDto> getAllCategories();
	
	
	
	

}
