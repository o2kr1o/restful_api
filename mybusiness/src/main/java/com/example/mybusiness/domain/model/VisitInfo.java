package com.example.mybusiness.domain.model;

import java.sql.Timestamp;

import lombok.Data;

/** Entity class for visit_info table */
@Data
public class VisitInfo {

	private Long visitId;
	private Long clientId;
	private Timestamp entryTime;
	private Timestamp exitTime;

}
