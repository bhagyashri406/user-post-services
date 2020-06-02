package com.socialmedia.userpostservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.userpostservices.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	public List<Comment> findByUserId(int userId);

	@Transactional
	public void deleteByUserId(int userId);
}
