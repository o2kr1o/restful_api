package com.example.mybusiness.controller.model.request;

import static com.example.mybusiness.common.constants.EnumConstants.RegexPatternConstants.*;
import static com.example.mybusiness.common.constants.EnumConstants.ValidationConstants.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

/** Request class for client table */
@Data
public class ClientRequest {

	@Positive(message = VALIDATION_INTEGER)
	private Long clientId;

	@NotBlank(message = VALIDATION_REQUIRED)
	@Size(max = 255, message = VALIDATION_SIZE_255)
	private String firstName;

	@NotBlank(message = VALIDATION_REQUIRED)
	@Size(max = 255, message = VALIDATION_SIZE_255)
	private String lastName;

	@NotBlank(message = VALIDATION_REQUIRED)
	@Size(max = 255, message = VALIDATION_SIZE_255)
	private String firstNameKana;

	@NotBlank(message = VALIDATION_REQUIRED)
	@Size(max = 255, message = VALIDATION_SIZE_255)
	private String lastNameKana;

	@NotNull(message = VALIDATION_REQUIRED)
	@Min(value = 16, message = VALIDATION_MIN)
	@Pattern(regexp = REGEX_AGE_PATTERN, message = VALIDATION_FORMAT)
	private String age;

	@NotNull(message = VALIDATION_REQUIRED)
	@Size(max = 5, message = VALIDATION_SIZE_5)
	private String gender;

	@Size(max = 155, message = VALIDATION_SIZE_155)
	private String workplace;

	@Size(max = 100, message = VALIDATION_SIZE_100)
	private String jobTitle;

	@NotBlank(message = VALIDATION_REQUIRED)
	@Pattern(regexp = REGEX_ZIP_CODE_PATTERN, message = VALIDATION_FORMAT)
	private String zipCode;

	@NotBlank(message = VALIDATION_REQUIRED)
	/** TODO check address maximum size */
	@Size(max = 255, message = VALIDATION_SIZE_255)
	private String address;

	@Size(max = 100, message = VALIDATION_SIZE_100)
	private String buildingName;

	@NotBlank(message = VALIDATION_REQUIRED)
	@Pattern(regexp = REGEX_NUMBER_PATTERN, message = VALIDATION_FORMAT)
	private String contactNumber;

	@NotBlank(message = VALIDATION_REQUIRED)
	/** TODO check a valid pattern format */
	@Pattern(regexp = REGEX_E_MAIL_PATTERN, message = VALIDATION_FORMAT)
	@Size(max = 254, message = VALIDATION_SIZE_254)
	private String eMail;

	@NotBlank(message = VALIDATION_REQUIRED)
	@Size(max = 10, message = VALIDATION_SIZE_10)
	private String paymentMethod;

}
