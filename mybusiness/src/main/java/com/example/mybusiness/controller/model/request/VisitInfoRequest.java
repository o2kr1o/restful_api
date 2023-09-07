package com.example.mybusiness.controller.model.request;

import static com.example.mybusiness.common.constants.EnumConstants.ValidationConstants.*;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

/** Request class for visit_info table */
@Data
public class VisitInfoRequest {

	@Positive(message = VALIDATION_INTEGER)
	private Long visitId;

	@NotNull(message = VALIDATION_REQUIRED)
	@Positive(message = VALIDATION_INTEGER)
	private Long clientId;

	private Timestamp entryTime;

	private Timestamp exitTime;

}
