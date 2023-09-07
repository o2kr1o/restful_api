package com.example.mybusiness.common.constants;

import lombok.Getter;

public enum EnumConstants {

	FIELD_NAME(ControllerConstants.FIELD_NAME),
	MESSAGE(ControllerConstants.MESSAGE),
	VALIDATION_MESSAGE(ControllerConstants.VALIDATION_MESSAGE),
	BAD_REQUEST_EXCEPTION_MESSAGE(ControllerConstants.BAD_REQUEST_EXCEPTION_MESSAGE),
	INTERNAL_SERVER_ERROR_MESSAGE(ControllerConstants.INTERNAL_SERVER_ERROR_MESSAGE),

	RESOURCE_NOT_FOUND_EXCEPTION_MESSAGE(ServiceConstants.RESOURCE_NOT_FOUND_EXCEPTION_MESSAGE),
	OK(ServiceConstants.OK),
	CREATED(ServiceConstants.CREATED),
	ACCEPTED(ServiceConstants.ACCEPTED),
	STATUS(ServiceConstants.STATUS),
	DELETED(ServiceConstants.DELETED),
	INSERTED(ServiceConstants.INSERTED),
	UPDATED(ServiceConstants.UPDATED),

	BAD_REQUEST(ExceptionHandlerConstants.BAD_REQUEST),
	NOT_FOUND(ExceptionHandlerConstants.NOT_FOUND),
	METHOD_NOT_ALLOWED(ExceptionHandlerConstants.METHOD_NOT_ALLOWED),
	UNSUPPORTED_MEDIA_TYPE(ExceptionHandlerConstants.UNSUPPORTED_MEDIA_TYPE),
	UNPROCESSABLE_ENTITY(ExceptionHandlerConstants.UNPROCESSABLE_ENTITY),
	INTERNAL_SERVER_ERROR(ExceptionHandlerConstants.INTERNAL_SERVER_ERROR);

	@Getter
	private final String value;

	private EnumConstants(String value) {
		this.value = value;
	}

	/** Define project-common constants in public static final */
	public final class ValidationConstants {
		/** No need to instantiate the class, we can hide its constructor */
		private ValidationConstants() {}
		public static final String VALIDATION_INTEGER = "Only integers are allowed";
		public static final String VALIDATION_REQUIRED = "This information is required";
		public static final String VALIDATION_SIZE_255 = "Please enter within 255 words";
		public static final String VALIDATION_SIZE_254 = "Please enter within 254 words";
		public static final String VALIDATION_SIZE_155 = "Please enter within 155 words";
		public static final String VALIDATION_SIZE_100 = "Please enter within 100 words";
		public static final String VALIDATION_SIZE_10 = "Please enter within 10 words";
		public static final String VALIDATION_SIZE_5 = "Please enter within 5 words";
		public static final String VALIDATION_MIN = "Please enter a number from 16 or more";
		public static final String VALIDATION_FORMAT = "This is not a valid format";
	}

	/** Define project-common constants in public static final */
	public final class RegexPatternConstants {
		/** No need to instantiate the class, we can hide its constructor */
		private RegexPatternConstants() {}
		public static final String REGEX_AGE_PATTERN = "^[0-9]{1,3}+$";
		public static final String REGEX_ZIP_CODE_PATTERN = "^[0-9]{3}-[0-9]{4}$";
		public static final String REGEX_NUMBER_PATTERN = "0\\d{1,4}-\\d{1,4}-\\d{4}";
		public static final String REGEX_E_MAIL_PATTERN = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$";
	}

	/** Define project-common constants in public static final */
	private final class ControllerConstants {
		/** No need to instantiate the class, we can hide its constructor */
		private ControllerConstants() {}
		public static final String FIELD_NAME = "Field: ";
		public static final String MESSAGE = " Message: ";
		public static final String VALIDATION_MESSAGE = "Form validation failed";
		public static final String BAD_REQUEST_EXCEPTION_MESSAGE = "An error occured while inserting record";
		public static final String INTERNAL_SERVER_ERROR_MESSAGE = "An internal server error occured while inserting record";
	}

	/** Define project-common constants in public static final */
	private final class ServiceConstants {
		/** No need to instantiate the class, we can hide its constructor */
		private ServiceConstants() {}
		public static final String RESOURCE_NOT_FOUND_EXCEPTION_MESSAGE = "Client not exist with client_id :";
		public static final String OK = "200 OK";
		public static final String CREATED = "201 Created";
		public static final String ACCEPTED = "202 Accepted";
		public static final String STATUS = "Status";
		public static final String DELETED = "Deleted";
		public static final String INSERTED = "Inserted";
		public static final String UPDATED = "Updated";
	}

	/** Define project-common constants in public static final */
	private final class ExceptionHandlerConstants {
		/** No need to instantiate the class, we can hide its constructor */
		private ExceptionHandlerConstants() {}
		public static final String BAD_REQUEST = "400 Bad Request";
		public static final String NOT_FOUND = "404 Not Found";
		public static final String METHOD_NOT_ALLOWED = "405 Method Not Allowed";
		public static final String UNSUPPORTED_MEDIA_TYPE = "415 Unsupported Media Type";
		public static final String UNPROCESSABLE_ENTITY = "422 Unprocessable Entity";
		public static final String INTERNAL_SERVER_ERROR = "500 Internal Server Error";
	}

	/** Define project-common constants in public static final */
	public final class LoggingAspectConstants {
		/** No need to instantiate the class, we can hide its constructor */
		private LoggingAspectConstants() {}
		public static final String START = "Start";
		public static final String END = "End";
		public static final String EXECUTE_METHOD_INFO = "Executing method information:";
		public static final String EXECUTE_FIND_ALL_DETAILS = "Executing findAllDetails method";
		public static final String EXECUTE_FIND_BY_ID = "Executing findById method";
		public static final String EXECUTE_DELETE_BY_ID = "Executing deleteById method";
		public static final String EXECUTE_INSERT = "Executing insert method";
		public static final String EXECUTE_UPDATE = "Executing update method";
		public static final String EXECUTE_FIND_DETAILS_BY_ID = "Executing findDetailsById method";
		public static final String EXECUTE_INSERT_ENTRY_TIME = "Executing insertEntryTime method";
		public static final String EXECUTE_UPDATE_EXIT_TIME = "Executing updateExitTime method";
		public static final String CLIENT_CONTROLLER = "within(com.example.mybusiness.controller.ClientController)";
		public static final String EXECUTE_FIND_All_CLIENTS_DETAILS = "execution(* com.example.mybusiness.controller.ClientController.findAllClientsDetails*(..))";
		public static final String EXECUTE_FIND_CLIENT_BY_ID = "execution(* com.example.mybusiness.controller.ClientController.findClientById*(..))";
		public static final String EXECUTE_DELETE_CLIENT = "execution(* com.example.mybusiness.controller.ClientController.deleteClient*(..))";
		public static final String EXECUTE_CREATE_CLIENT = "execution(* com.example.mybusiness.controller.ClientController.createClient*(..))";
		public static final String EXECUTE_UPDATE_CLIENT = "execution(* com.example.mybusiness.controller.ClientController.updateClient*(..))";
		public static final String EXECUTE_FIND_CLIENT_DETAILS_BY_ID = "execution(* com.example.mybusiness.controller.ClientController.findClientDetailsById*(..))";
		public static final String EXECUTE_INSERT_ENTRY_TIME_DATA = "execution(* com.example.mybusiness.controller.ClientController.insertEntryTimeData*(..))";
		public static final String EXECUTE_UPDATE_EXIT_TIME_DATA = "execution(* com.example.mybusiness.controller.ClientController.updateExitTimeData*(..))";
	}

}
