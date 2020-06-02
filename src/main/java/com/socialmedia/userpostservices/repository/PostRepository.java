package com.socialmedia.userpostservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.userpostservices.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	public Post findByUserId(int userId);

	@Transactional
	public void deleteByUserId(int userId);
}
