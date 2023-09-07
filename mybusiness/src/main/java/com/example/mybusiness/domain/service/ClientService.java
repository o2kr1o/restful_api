package com.example.mybusiness.domain.service;

import static com.example.mybusiness.common.constants.EnumConstants.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mybusiness.controller.model.request.ClientRequest;
import com.example.mybusiness.controller.model.request.VisitInfoRequest;
import com.example.mybusiness.controller.model.response.Response;
import com.example.mybusiness.domain.model.Client;
import com.example.mybusiness.domain.repository.ClientMapper;
import com.example.mybusiness.domain.repository.VisitInfoMapper;
import com.example.mybusiness.exception.BadRequestException;
import com.example.mybusiness.exception.ResourceNotFoundException;

/** Service class */
@Service
public class ClientService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private VisitInfoMapper visitInfoMapper;

	public List<Client> findAllDetails() {
		logger.info(OK.getValue());
		return visitInfoMapper.findAllDetails();
	}

	public Client findById(Long clientId) {
		Client client = clientMapper
				.findById(clientId)
				.orElseThrow(
						() -> new ResourceNotFoundException(
								RESOURCE_NOT_FOUND_EXCEPTION_MESSAGE.getValue() + clientId));
		logger.info(OK.getValue());
		return client;
	}

	@Transactional
	public Map<String, Object> deleteById(Long clientId) {
		Client client = clientMapper.findById(clientId)
				.orElseThrow(
						() -> new ResourceNotFoundException(
								RESOURCE_NOT_FOUND_EXCEPTION_MESSAGE.getValue() + clientId));
		Map<String, Object> response = new HashMap<>();
		boolean bool = clientMapper.deleteById(client.getClientId()) > 0;
		response.put(STATUS.getValue(), HttpStatus.OK.value());
		response.put(DELETED.getValue(), bool);
		if (bool == true)
			logger.info(OK.getValue());
		return response;
	}

	@Transactional
	public Map<String, Object> insert(ClientRequest clientRequest) {
		Map<String, Object> response = new HashMap<>();
		boolean bool = clientMapper.insert(clientRequest) > 0;
		response.put(STATUS.getValue(), HttpStatus.CREATED.value());
		response.put(INSERTED.getValue(), bool);
		if (bool == true)
			logger.info(CREATED.getValue());
		return response;
	}

	@Transactional
	public Map<String, Object> update(Long clientId, ClientRequest clientRequest) {
		clientMapper
				.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException(
						RESOURCE_NOT_FOUND_EXCEPTION_MESSAGE.getValue() + clientId));
		clientRequest.setClientId(clientId);
		Map<String, Object> response = new HashMap<>();
		boolean bool = clientMapper.update(clientRequest) > 0;
		response.put(STATUS.getValue(), HttpStatus.CREATED.value());
		response.put(UPDATED.getValue(), bool);
		if (bool == true)
			logger.info(CREATED.getValue());
		return response;
	}

	public Response findDetailsById(Long clientId) {
		Response response = new Response();
		ModelMapper modelMapper = new ModelMapper();
		Client client = visitInfoMapper
				.findDetailsById(clientId)
				.orElseThrow(
						() -> new ResourceNotFoundException(
								RESOURCE_NOT_FOUND_EXCEPTION_MESSAGE.getValue() + clientId));
		response = modelMapper.map(client, Response.class);
		response.setVisitInfoList(client.getVisitInfoList());
		logger.info(OK.getValue());
		return response;
	}

	@Transactional
	public Map<String, Object> insertEntryTime(VisitInfoRequest visitInfoRequest) {
		if (visitInfoRequest.getExitTime() != null
				|| (visitInfoRequest.getExitTime() == null) && (visitInfoRequest.getEntryTime() == null)) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
		}
		Map<String, Object> response = new HashMap<>();
		boolean bool = visitInfoMapper.insertEntryTime(visitInfoRequest) > 0;
		response.put(STATUS.getValue(), HttpStatus.CREATED.value());
		response.put(INSERTED.getValue(), bool);
		if (bool == true)
			logger.info(CREATED.getValue());
		return response;
	}

	@Transactional
	public Map<String, Object> updateExitTime(VisitInfoRequest visitInfoRequest) {
		if (visitInfoRequest.getEntryTime() != null
				|| (visitInfoRequest.getExitTime() == null) && (visitInfoRequest.getEntryTime() == null)) {
			throw new BadRequestException(HttpStatus.BAD_REQUEST, BAD_REQUEST_EXCEPTION_MESSAGE.getValue());
		}
		Map<String, Object> response = new HashMap<>();
		boolean bool = visitInfoMapper.updateExitTime(visitInfoRequest) > 0;
		response.put(UPDATED.getValue(), bool);
		if (bool == true) {
			response.put(STATUS.getValue(), HttpStatus.CREATED.value());
			logger.info(CREATED.getValue());
		} else {
			response.put(STATUS.getValue(), HttpStatus.ACCEPTED.value());
			logger.info(ACCEPTED.getValue());
		}
		return response;
	}

}
