package com.project.BlogApplication.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApplication.Dto.CategoryDto;
import com.project.BlogApplication.Service.CategoryService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
	
	CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto addCategoryDto=this.categoryService.addCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(addCategoryDto,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable int id){
		CategoryDto updatedCategoryDto=this.categoryService.updateCategory(categoryDto,id);
		return new ResponseEntity<CategoryDto>(updatedCategoryDto,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		this.categoryService.deleteCategoryById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
//	@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> categoryList=categoryService.getAllCategories();
		return new ResponseEntity<>(categoryList,HttpStatus.OK) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id){
		CategoryDto category=this.categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
		
	}

}
