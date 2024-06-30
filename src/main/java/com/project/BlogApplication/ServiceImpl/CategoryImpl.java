package com.project.BlogApplication.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.BlogApplication.Dto.CategoryDto;
import com.project.BlogApplication.Entity.Category;
import com.project.BlogApplication.Exception.ResourceNotFoundException;
import com.project.BlogApplication.Repository.CategoryRepository;
import com.project.BlogApplication.Service.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoryImpl implements CategoryService {
	
	CategoryRepository categoryRepo;
	ModelMapper modelMapper;

	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		
		Category category= this.modelMapper.map(categoryDto, Category.class);
		Category savedCategory=this.categoryRepo.save(category);
		CategoryDto newCategoryDto=this.modelMapper.map(savedCategory, CategoryDto.class);
		return newCategoryDto;
	}

	@Override
	public void deleteCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "Category id", id));
		this.categoryRepo.delete(category);
	
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category=this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", id));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto,int id) {
		Category category=this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", id));
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		Category updatedCategory=this.categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categoryItem= this.categoryRepo.findAll();
		List<CategoryDto> categoryDtoItem=categoryItem.stream().map((item)->this.modelMapper.map(item, CategoryDto.class)).collect(Collectors.toList());
	 return categoryDtoItem;
	}

}
