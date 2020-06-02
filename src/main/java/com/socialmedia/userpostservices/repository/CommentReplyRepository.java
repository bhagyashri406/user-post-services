package com.socialmedia.userpostservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.socialmedia.userpostservices.model.CommentReply;
import com.socialmedia.userpostservices.model.Reply;

@Repository
public interface CommentReplyRepository extends JpaRepository<CommentReply, Integer>, CommentRepositoryCustom {

	List<CommentReply> findByPostId(int postId);

}
