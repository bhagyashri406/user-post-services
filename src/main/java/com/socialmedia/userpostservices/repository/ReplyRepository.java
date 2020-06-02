package com.socialmedia.userpostservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.userpostservices.model.Comment;
import com.socialmedia.userpostservices.model.Post;
import com.socialmedia.userpostservices.model.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	public Reply findByUserId(int userId);

	@Transactional
	public Reply deleteByUserId(int userId);
}
