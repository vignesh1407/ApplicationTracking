package com.applicationTracking.AssignmentLogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "trackingResult", uniqueConstraints = @UniqueConstraint(columnNames = "applicationNumber"))
public class UserContent {

	@Id
	@Column(name = "applicationNumber")
	private Long applicationNumber;
	@Column(name = "studentEmail")
	private String studentEmail;
	@Column(name = "genderRef")
	private String genderRef;
	@Column(name = "updatedBy")
	private String updatedBy;
	@Column(name = "email")
	private String email;

	@DateTimeFormat(pattern = "dd.mm.yyy")
	@Column(name = "updatedDate")
	private Date updatedDate;
	@Column(name = "waitingTime")
	private String waitingTime;
	@Column(name = "document")
	private String document;
	@Column(name = "missingDocuments")
	private String missingDocuments;

	public UserContent() {

	}

	public UserContent(Long applicationNumber, String studentEmail, String genderRef, String updatedBy, String email,
			Date updatedDate, String waitingTime, String document, String missingDocuments) {
		super();
		this.applicationNumber = applicationNumber;
		this.studentEmail = studentEmail;
		this.genderRef = genderRef;
		this.updatedBy = updatedBy;
		this.email = email;
		this.updatedDate = updatedDate;
		this.waitingTime = waitingTime;
		this.document = document;
		this.missingDocuments = missingDocuments;
	}

	public Long getApplicationNumber() {
		return applicationNumber;
	}

	public void setApplicationNumber(Long applicationNumber2) {
		this.applicationNumber = applicationNumber2;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getGenderRef() {
		return genderRef;
	}

	public void setGenderRef(String genderRef) {
		this.genderRef = genderRef;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(String waitingTime) {
		this.waitingTime = waitingTime;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getMissingDocuments() {
		return missingDocuments;
	}

	public void setMissingDocuments(String missingDocuments) {
		this.missingDocuments = missingDocuments;
	}
	
}
