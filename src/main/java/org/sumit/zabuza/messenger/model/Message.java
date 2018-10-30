package org.sumit.zabuza.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
	private long id;
	private String messages;
	private Date created;
	private String author;
	
	public Message()
	{
		
	}
	
	public Message(long id, String messages, Date created, String author) {
		super();
		this.id = id;
		this.messages = messages;
		this.created = created;
		this.author = author;
	}

	public Message(long id, String messages,String author) {
		super();
		this.id = id;
		this.messages = messages;
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessages() {
		return messages;
	}
	public void setMessages(String messages) {
		this.messages = messages;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
