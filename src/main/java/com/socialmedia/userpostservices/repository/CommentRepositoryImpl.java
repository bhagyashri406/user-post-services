package com.socialmedia.userpostservices.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.socialmedia.userpostservices.model.CommentReply;

@Repository
@Transactional(readOnly = true)
public class CommentRepositoryImpl implements CommentRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<CommentReply> findByUser(int user) {
		// TODO Auto-generated method stub

		Query query = entityManager.createNativeQuery("SELECT em.* FROM Comment_reply as em " + "WHERE em.user LIKE ?",
				CommentReply.class);
		query.setParameter(1, user + "%");

		return query.getResultList();

	}

	@Override
	public void deleteByUser(int user) {
		Query query = entityManager.createNativeQuery("DELETE em.* FROM Comment_reply as em " + "WHERE em.user LIKE ?",
				CommentReply.class);
		query.setParameter(1, user + "%");

		System.out.println("query: " + query.toString());

	}

}