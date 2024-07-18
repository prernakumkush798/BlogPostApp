package com.project.BlogApplication.ServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BlogApplication.Dto.PostDto;
import com.project.BlogApplication.Entity.Category;
import com.project.BlogApplication.Entity.Post;
import com.project.BlogApplication.Entity.User;
import com.project.BlogApplication.Exception.ResourceNotFoundException;
import com.project.BlogApplication.Repository.CategoryRepository;
import com.project.BlogApplication.Repository.PostRepository;
import com.project.BlogApplication.Repository.UserRepository;
import com.project.BlogApplication.Service.PostService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CategoryRepository categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto addPost(PostDto postDto, int userId, int categoryId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "User Id", userId));
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setDate(new Date());
		post.setImageName("default.png");
		post.setUser(user);
		post.setCategory(category);
		this.postRepo.save(post);
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostDto getPostById(int id) {
		Post post = this.postRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", id));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts = this.postRepo.findAll();
		List<PostDto> postDto = posts.stream().map(item -> this.modelMapper.map(item, PostDto.class))
				.collect(Collectors.toList());
		return postDto;
	}

//	@Override
//	public PostDto updatePost(PostDto postDto, int id) {
//		Post post = this.postRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", id));
//		post.setContent(postDto.getContent());
//		post.setTitle(postDto.getTitle());
//		post.setCategory(postDto.getCategory());
//		post.setDate(postDto.getDate());
//		post.setUser(postDto.getUser());
//		post.setImageName(postDto.getImageName());
//		Post savedPost = this.postRepo.save(post);
//		return this.modelMapper.map(savedPost, PostDto.class);
//	}
//
//	@Override
//	public void deletePost(int id) {
//		this.postRepo.deleteById(id);
//
//	}
//
	

	@Override
	public List<PostDto> getPostByCategory(int categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", categoryId));
		List<Post> posts=this.postRepo.findByCategory(category);
		List<PostDto> postDtos=posts.stream().map(item->this.modelMapper.map(item, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(int userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		List<Post> posts=this.postRepo.findByUser(user);
		List<PostDto> postDtos=posts.stream().map(item->this.modelMapper.map(item, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}



}
