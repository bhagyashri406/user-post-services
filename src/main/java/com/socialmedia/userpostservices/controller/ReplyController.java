package com.socialmedia.userpostservices.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.socialmedia.userpostservices.model.Post;
import com.socialmedia.userpostservices.model.Reply;
import com.socialmedia.userpostservices.repository.*;

@RestController
public class ReplyController {

	@Autowired
	ReplyRepository ReplyRepository;

	@PostMapping(path = "reply")
	public ResponseEntity<Map<String, String>> createReply(@Valid @RequestBody Reply reply) {

		Reply Reply = ReplyRepository.save(reply);

		Map<String, String> response = new HashMap<String, String>();

		response.put("message", "reply save successfully ");
		return ResponseEntity.accepted().body(response);

	}

	@GetMapping(path = "/reply")
	public List<Reply> retrieveAllReply() {
		return ReplyRepository.findAll();
	}

	@GetMapping(path = "/reply/{id}")
	public Optional<Reply> retrieveReply(@PathVariable int replyId) throws Exception {
		Optional<Reply> user = ReplyRepository.findById(replyId);
		if (!user.isPresent())
			throw new Exception("reply is not Exist : id -" + replyId);

		return user;
	}

	@DeleteMapping(path = "/delete/reply{userId}")
	public ResponseEntity<Map<String, String>> deleteReplyByUserId(@PathVariable int userId) {

		ReplyRepository.deleteByUserId(userId);

		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "User reply Delete successfully ");
		return ResponseEntity.accepted().body(response);

	}
}
