package com.project.BlogApplication.Dto;

import java.util.Date;

import com.project.BlogApplication.Entity.Category;
import com.project.BlogApplication.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

	private String title;
	private String content;
	private String imageName;
	private Date date;

	private UserDto user;

	private CategoryDto category;

}
