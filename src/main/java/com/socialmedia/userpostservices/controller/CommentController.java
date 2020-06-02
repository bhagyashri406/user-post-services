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
import com.socialmedia.userpostservices.model.Post;
import com.socialmedia.userpostservices.repository.CommentRepository;
import com.socialmedia.userpostservices.repository.PostRepository;

@RestController
public class CommentController {

	@Autowired
	CommentRepository commentRepository;

	@PostMapping(path = "comment")
	public ResponseEntity<Map<String, String>> createReply(@Valid @RequestBody Comment comment) {

		Comment _comment = commentRepository.save(comment);

		Map<String, String> response = new HashMap<String, String>();

		response.put("message", "comment save successfully ");
		return ResponseEntity.accepted().body(response);

	}

	@GetMapping(path = "/comment")
	public List<Comment> retrieveAllComment() {
		return commentRepository.findAll();
	}

	@GetMapping(path = "/comment/{Id}")
	public Optional<Comment> retrievePost(@PathVariable int Id) throws Exception {

		Optional<Comment> comment = commentRepository.findById(Id);
		if (!comment.isPresent())
			throw new Exception("reply is not Exist : id -" + Id);

		return comment;
	}

	@DeleteMapping(path = "/delete/comment/{userId}")
	public ResponseEntity<Map<String, String>> deletePostByUserId(@PathVariable int userId) {

		commentRepository.deleteByUserId(userId);

		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "User Comment Delete successfully ");
		return ResponseEntity.accepted().body(response);
	}

}
