package com.example.mybusiness.log;

import static com.example.mybusiness.common.constants.EnumConstants.LoggingAspectConstants.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/** Logging class for Aspect Oriented Programming */
@Aspect
@Component
public class CustomLoggingAspect {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before(CLIENT_CONTROLLER)
	public void commonLog(JoinPoint jp) {
		logger.info(START);
		logger.info(EXECUTE_METHOD_INFO + jp.getSignature().toString());
	}

	@Before(EXECUTE_FIND_All_CLIENTS_DETAILS)
	public void postFindAllDetailsLog(JoinPoint jp) {
		logger.info(EXECUTE_FIND_ALL_DETAILS);
		logger.info(END);
	}

	@Before(EXECUTE_FIND_CLIENT_BY_ID)
	public void postFindByIdLog(JoinPoint jp) {
		logger.info(EXECUTE_FIND_BY_ID);
		logger.info(END);
	}

	@Before(EXECUTE_DELETE_CLIENT)
	public void postDeleteByIdLog(JoinPoint jp) {
		logger.info(EXECUTE_DELETE_BY_ID);
		logger.info(END);
	}

	@Before(EXECUTE_CREATE_CLIENT)
	public void postInsertLog(JoinPoint jp) {
		logger.info(EXECUTE_INSERT);
		logger.info(END);
	}

	@Before(EXECUTE_UPDATE_CLIENT)
	public void postUpdateLog(JoinPoint jp) {
		logger.info(EXECUTE_UPDATE);
		logger.info(END);
	}

	@Before(EXECUTE_FIND_CLIENT_DETAILS_BY_ID)
	public void postFindDetailsByIdLog(JoinPoint jp) {
		logger.info(EXECUTE_FIND_DETAILS_BY_ID);
		logger.info(END);
	}

	@Before(EXECUTE_INSERT_ENTRY_TIME_DATA)
	public void postInsertEntryTimeLog(JoinPoint jp) {
		logger.info(EXECUTE_INSERT_ENTRY_TIME);
		logger.info(END);
	}

	@Before(EXECUTE_UPDATE_EXIT_TIME_DATA)
	public void postUpdatetExitTimeLog(JoinPoint jp) {
		logger.info(EXECUTE_UPDATE_EXIT_TIME);
		logger.info(END);
	}

}
