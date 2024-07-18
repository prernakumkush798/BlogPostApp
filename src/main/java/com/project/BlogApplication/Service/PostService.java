package com.project.BlogApplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.BlogApplication.Dto.PostDto;

@Service
public interface PostService {
	
	PostDto addPost(PostDto postDto,int userId,int categoryId);

	PostDto getPostById(int id);

	List<PostDto> getAllPost();
//
//	Post updatePost(PostDto postDto, int id);
//
//	void deletePost(int id);
//	
	List<PostDto> getPostByCategory(int categoryId);
	
	List<PostDto> getPostByUser(int userId);

}
