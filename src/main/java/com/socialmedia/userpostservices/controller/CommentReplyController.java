package com.socialmedia.userpostservices.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.userpostservices.model.Comment;
import com.socialmedia.userpostservices.model.CommentReply;
import com.socialmedia.userpostservices.repository.CommentReplyRepository;
import com.socialmedia.userpostservices.repository.CommentRepository;

@RestController
public class CommentReplyController {

	@Autowired
	CommentReplyRepository commentReplyRepository;

	@PostMapping(path = "comment_reply")
	public ResponseEntity<Map<String, String>> createReply(@Valid @RequestBody CommentReply comment) {

		CommentReply _comment = commentReplyRepository.save(comment);

		Map<String, String> response = new HashMap<String, String>();

		response.put("message", "comment/reply save successfully ");
		return ResponseEntity.accepted().body(response);

	}

	@GetMapping(path = "/comment_reply")
	public List<CommentReply> retrieveAllPost() {
		return commentReplyRepository.findAll();
	}

	@GetMapping(path = "/comment_reply/{id}")
	public Optional<CommentReply> retrievePost(@PathVariable int id) throws Exception {

		Optional<CommentReply> comment = commentReplyRepository.findById(id);
		if (!comment.isPresent())
			throw new Exception("reply is not Exist : id -" + id);

		return comment;
	}

	@GetMapping(path = "/get/comment_reply/{user}")
	public List<CommentReply> getCommentsReplyByUserId(@PathVariable int user) {

		List<CommentReply> commentReplies = commentReplyRepository.findByUser(user);

		Map<String, String> response = new HashMap<String, String>();
			return commentReplies;
	}

	@DeleteMapping(path = "/delete/comment_reply/{user}")
	public ResponseEntity<Map<String, String>> deleteCommentsReplyByUserId(@PathVariable int user) {

		commentReplyRepository.deleteByUser(user);

		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "User Comment Delete successfully ");
		response.put("maxcount", "selete");

		return ResponseEntity.accepted().body(response);
	}

	@GetMapping(path = "/get/comment_reply_by_post/{postId}")
	public List<CommentReply> getCommentsReplyByPostId(@PathVariable int postId) {

		List<CommentReply> commentReplies = commentReplyRepository.findByPostId(postId);
		return commentReplies;
	}
}
