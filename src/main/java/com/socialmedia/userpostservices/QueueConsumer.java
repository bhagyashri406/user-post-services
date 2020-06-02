package com.socialmedia.userpostservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.socialmedia.userpostservices.model.NotificationDTO;
import com.socialmedia.userpostservices.repository.CommentReplyRepository;

@Component
public class QueueConsumer {

	Logger logger = LoggerFactory.getLogger(getClass());
	String EVENT_USER_DELETE ="UserDeleted";

	@Autowired
	CommentReplyRepository commentReplyRepository;

	public void receiveMessage(String message) {
		logger.info("Received (String) " + message);
		processMessage(message);
	}

	public void receiveMessage(byte[] message) {
		String strMessage = new String(message);
		logger.info("Received (No String) " + strMessage);
		processMessage(strMessage);
	}

	private void processMessage(String message) {
		try {
			NotificationDTO dto = new ObjectMapper().readValue(message, NotificationDTO.class);

			logger.info("Received (dto) " + dto.getEvent());
			logger.info("Received (dto) " + dto.getUserid());

			if (dto.getEvent().equals(EVENT_USER_DELETE)) {
				int user =dto.getUserid() ;
				commentReplyRepository.deleteByUser(user);
				logger.info("Received (dto) " + dto.getEvent());
				logger.info("Received (dto) " + dto.getUserid());
			} else {

				logger.error("Received (errot) " + dto.getEvent().equals(EVENT_USER_DELETE));
			}

			// mailServiceImpl.sendMail(mailDTO, null);
		} catch (JsonParseException e) {
			logger.warn("Bad JSON in message: " + message);
		} catch (JsonMappingException e) {
			logger.warn("cannot map JSON to NotificationRequest: " + message);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}