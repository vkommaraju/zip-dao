package com.dxc.zurich.innovation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
@SequenceGenerator(name = "message_sequence", sequenceName = "message_id_seq")
public class Message extends AbstractEntity {
	
	private static final long serialVersionUID = 7422574264557894633L;
	private Integer id;
	private Date messageDate;
	
	@Lob
	@Column( length = 100000 )
	private String message;
	
	private String sender;
	private String receiver;
	private String event;
	
	private boolean responded;
	
	@Lob
	@Column( length = 100000 )
	private String response;
	
	private long responseDateMillis;
	private String responseDate;
	
	public Date getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isResponded() {
		return responded;
	}

	public void setResponded(boolean responded) {
		this.responded = responded;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public long getResponseDateMillis() {
		return responseDateMillis;
	}

	public void setResponseDateMillis(long responseDateMillis) {
		this.responseDateMillis = responseDateMillis;
	}

	public String getResponseDate() {
		return responseDate;
	}

	public void setResponseDate(String responseDate) {
		this.responseDate = responseDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "message_sequence")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
}