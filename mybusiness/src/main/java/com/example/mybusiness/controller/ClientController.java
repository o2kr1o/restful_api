package com.example.mybusiness.controller;

import static com.example.mybusiness.common.constants.EnumConstants.*;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybusiness.controller.model.request.ClientRequest;
import com.example.mybusiness.controller.model.request.VisitInfoRequest;
import com.example.mybusiness.controller.model.response.Response;
import com.example.mybusiness.domain.model.Client;
import com.example.mybusiness.domain.service.ClientService;
import com.example.mybusiness.exception.BadRequestException;
import com.example.mybusiness.exception.InternalServerError;
import com.example.mybusiness.exception.UnprocessableEntityException;

/** Controller class */
@RestController
@RequestMapping("/api/v1")
public class ClientController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ClientService clientService;

	/** Get all clients rest api */
	@GetMapping("/clients")
	public List<Client> findAllClientsDetails() {
		return clientService.findAllDetails();
	}

	/** Get client by client_id rest api */
	@GetMapping("/clients/{clientId}")
	public Client findClientById(@PathVariable Long clientId) {
		return clientService.findById(clientId);
	}

	/** Delete client rest api */
	@DeleteMapping("/clients/{clientId}")
	public Map<String, Object> deleteClient(@PathVariable Long clientId) {
		return clientService.deleteById(clientId);
	}

	/** Create client rest api */
	@PostMapping("/clients")
	public Map<String, Object> createClient(@RequestBody @Valid ClientRequest clientRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors()) {
				logger.error(FIELD_NAME.getValue() + error.getField() + MESSAGE.getValue() + error.getDefaultMessage());
			}
			throw new UnprocessableEntityException(HttpStatus.UNPROCESSABLE_ENTITY, VALIDATION_MESSAGE.getValue());
		}
		try {
			return clientService.insert(clientRequest);
			/** TODO find Bad Request cause for evidence */
		} catch (RuntimeException e) {
			logger.error(BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
			throw new BadRequestException(HttpStatus.BAD_REQUEST, BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
		} catch (Exception e) {
			logger.error(INTERNAL_SERVER_ERROR_MESSAGE.getValue());
			throw new InternalServerError(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE.getValue());
		}
	}

	/** Update client rest api */
	@PutMapping("/clients/{clientId}")
	public Map<String, Object> updateClient(@PathVariable Long clientId,
			@RequestBody @Valid ClientRequest clientRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors()) {
				logger.error(FIELD_NAME.getValue() + error.getField() + MESSAGE.getValue() + error.getDefaultMessage());
			}
			throw new UnprocessableEntityException(HttpStatus.UNPROCESSABLE_ENTITY, VALIDATION_MESSAGE.getValue());
		}
		return clientService.update(clientId, clientRequest);
	}

	/** Get client details by client_id rest api */
	@GetMapping("/clientDetails/{clientId}")
	public Response findClientDetailsById(@PathVariable Long clientId) {
		return clientService.findDetailsById(clientId);
	}

	/** Create entry_time data rest api */
	@PostMapping("/visitInfo/entryTime")
	public Map<String, Object> insertEntryTimeData(@RequestBody @Valid VisitInfoRequest visitInfoRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors()) {
				logger.error(FIELD_NAME.getValue() + error.getField() + MESSAGE.getValue() + error.getDefaultMessage());
			}
			throw new UnprocessableEntityException(HttpStatus.UNPROCESSABLE_ENTITY, VALIDATION_MESSAGE.getValue());
		}
		try {
			return clientService.insertEntryTime(visitInfoRequest);
		} catch (RuntimeException e) {
			logger.error(BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
			throw new BadRequestException(HttpStatus.BAD_REQUEST, BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
		} catch (Exception e) {
			logger.error(INTERNAL_SERVER_ERROR_MESSAGE.getValue());
			throw new InternalServerError(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE.getValue());
		}
	}

	/** Update exit_time data rest api */
	@PostMapping("/visitInfo/exitTime")
	public Map<String, Object> updateExitTimeData(@RequestBody @Valid VisitInfoRequest visitInfoRequest, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors()) {
				logger.error(FIELD_NAME.getValue() + error.getField() + MESSAGE.getValue() + error.getDefaultMessage());
			}
			throw new UnprocessableEntityException(HttpStatus.UNPROCESSABLE_ENTITY, VALIDATION_MESSAGE.getValue());
		}
		try {
			return clientService.updateExitTime(visitInfoRequest);
		} catch (RuntimeException e) {
			logger.error(BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
			throw new BadRequestException(HttpStatus.BAD_REQUEST, BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
		} catch (Exception e) {
			logger.error(INTERNAL_SERVER_ERROR_MESSAGE.getValue());
			throw new InternalServerError(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MESSAGE.getValue());
		}
	}

}
