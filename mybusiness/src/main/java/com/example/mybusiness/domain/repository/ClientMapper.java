package com.example.mybusiness.domain.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.mybusiness.controller.model.request.ClientRequest;
import com.example.mybusiness.domain.model.Client;

/** Mapper interface for client table */
@Mapper
public interface ClientMapper {

	Optional<Client> findById(Long clientId);

	int deleteById(Long id);

	int insert(ClientRequest clientRequest);

	int update(ClientRequest clientRequest);

}
