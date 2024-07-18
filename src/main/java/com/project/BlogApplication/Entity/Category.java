package com.project.BlogApplication.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Column(name = "Description", nullable = false, length = 100)
	private String categoryDescription;
	
	@Column(name = "Title", nullable = false, length = 10,unique = true)
	private String categoryTitle;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Post> post;
	
	 

}
