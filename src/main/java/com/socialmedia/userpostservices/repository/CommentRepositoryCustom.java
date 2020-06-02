package com.socialmedia.userpostservices.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.userpostservices.model.CommentReply;

public interface CommentRepositoryCustom {

	public List<CommentReply> findByUser(int user);
	@Transactional
	public void deleteByUser(int user);

}
