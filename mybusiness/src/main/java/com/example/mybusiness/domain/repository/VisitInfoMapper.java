package com.example.mybusiness.domain.repository;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.mybusiness.controller.model.request.VisitInfoRequest;
import com.example.mybusiness.domain.model.Client;

/** Mapper interface for client table and visit_info table */
@Mapper
public interface VisitInfoMapper {

	List<Client> findAllDetails();

	Optional<Client> findDetailsById(Long clientId);

	int insertEntryTime(VisitInfoRequest visitInfoRequest);

	int updateExitTime(VisitInfoRequest visitInfoRequest);

}
