package com.capstone.medicare.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.medicare.model.Category;
import com.capstone.medicare.repository.CategoryRepository;

@Service
class CategoryServiceImpl implements CategoryService
{
	//injected the Repository dependency
		@Autowired
		CategoryRepository repo;

		@Override
		public Category saveCategory(Category c) {
			return repo.save(c);
		}

		@Override
		public List<Category> getAllCategory() {
			return repo.findAll();
		}

		@Override
		public Category updateCategory(Category newData, int id) {
			if (repo.findById((long) id).isPresent()) {
				Category oldData = repo.findById((long) id).get();
				oldData.setCategoryName(newData.getCategoryName());
				oldData.setCategoryDesc(newData.getCategoryDesc());
				
				return repo.save(oldData);
			} 
			else
				return null;
		}

		@Override
		public boolean deleteCategory(int id) {
			if (repo.findById((long) id).isPresent()) {
				repo.deleteById((long) id);
				return true;
			}
			return false;
		}

		@Override
		public Category getCategoryById(int id) {
			if (repo.findById((long) id).isPresent()) {
				return repo.findById((long) id).get();
			}
			return null;
		}

}
