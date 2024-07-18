package com.project.BlogApplication.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.BlogApplication.Entity.Category;
import com.project.BlogApplication.Entity.Post;
import com.project.BlogApplication.Entity.User;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{
	List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);

}
