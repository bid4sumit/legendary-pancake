package org.sumit.zabuza.messenger.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.sumit.zabuza.messenger.Exceptions.DataNotFoundException;
import org.sumit.zabuza.messenger.database.Database;
import org.sumit.zabuza.messenger.model.*;

public class MessageService {

	private Map<Long, Message> messages = Database.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1L, "Hello World", new Date(), "Sumit"));
		messages.put(2L, new Message(2L, "Hello X", "Xabuxa"));
	}

	public List<Message> getAllMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public List<Message> getAllMessagesforYear(int year) {
		List<Message> messagesForYear = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Message message : messages.values()) {
			if (message.getCreated() != null) {
				if (calendar.get(Calendar.YEAR) == year) {
					messagesForYear.add(message);
				}
			}
		}
		return messagesForYear;
	}

	public List<Message> getAllMessagesPaginated(int start, int size) {
		List<Message> messagesPaginated = new ArrayList<>(messages.values());

		return messagesPaginated.subList(start, start + size);
	}

	public Message getMessage(Long id) {
		Message temp_msg = messages.get(id);
		
		if(temp_msg==null)
		{
			throw new DataNotFoundException("Message with ID "+id+"  Not Found");
		}
		return messages.get(id);
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() <= 0) {
			return null;
		}
		return messages.replace(message.getId(), message);
	}

	public Message removeMessage(Long id) {
		return messages.remove(id);
	}

}
