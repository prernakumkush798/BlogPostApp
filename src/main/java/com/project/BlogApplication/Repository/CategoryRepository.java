package com.project.BlogApplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.BlogApplication.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
