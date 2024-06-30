package com.project.BlogApplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	int categoryId;
	String categoryDescription;
	String categoryTitle;

}
