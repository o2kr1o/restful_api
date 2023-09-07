package com.example.mybusiness.controller.model.response;

import java.util.List;

import com.example.mybusiness.domain.model.VisitInfo;

import lombok.Data;

/** Response class */
@Data
public class Response {

	private Long clientId;
	private String firstName;
	private String lastName;
	private String firstNameKana;
	private String lastNameKana;
	private String age;
	private String gender;
	private String workplace;
	private String jobTitle;
	private String zipCode;
	private String address;
	private String buildingName;
	private String contactNumber;
	private String eMail;
	private String paymentMethod;

	private List<VisitInfo> visitInfoList;

}
