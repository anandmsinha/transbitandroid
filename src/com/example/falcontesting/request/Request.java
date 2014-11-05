package com.example.falcontesting.request;

public class Request {
	
	private String id;
	
	private String subject;
	
	private String requestDetails;
	
	private String requestTime;
	
	public Request(String id, String subject, String details, String time) {
		this.id = id;
		this.subject = subject;
		this.requestDetails = details;
		this.requestTime = time;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRequestDetails() {
		return requestDetails;
	}

	public void setRequestDetails(String requestDetails) {
		this.requestDetails = requestDetails;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}
	
}
