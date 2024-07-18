package com.project.BlogApplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApplication.Dto.PostDto;
import com.project.BlogApplication.Entity.Post;
import com.project.BlogApplication.Service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postservice;
	

	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto,@PathVariable int userId, @PathVariable int categoryId) {
		PostDto addPost = this.postservice.addPost(postDto,userId,categoryId);
		return new ResponseEntity<PostDto>(addPost, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPosts() {
		List<PostDto> posts=this.postservice.getAllPost();
		return new ResponseEntity<>(posts, HttpStatus.OK);

	}
	@GetMapping("/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable int id){
		PostDto post=this.postservice.getPostById(id);
		return new ResponseEntity<PostDto>(post,HttpStatus.OK);
		
	}
	
	@GetMapping("/user/{id}/posts")
	public ResponseEntity<List<PostDto>> getAllPostByUserId(@PathVariable int id){
		List<PostDto> posts=this.postservice.getPostByUser(id);
		return new ResponseEntity<>(posts,HttpStatus.OK);
		
	}
	@GetMapping("/category/{id}/posts")
	public ResponseEntity<List<PostDto>> getAllPostByCategoryId(@PathVariable int id){
		List<PostDto> posts=this.postservice.getPostByCategory(id);
		return new ResponseEntity<>(posts,HttpStatus.OK);
		
	}
}
