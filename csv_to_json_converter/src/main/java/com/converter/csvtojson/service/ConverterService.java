package com.converter.csvtojson.service;

import org.springframework.web.multipart.MultipartFile;

import com.converter.csvtojson.exceptions.CustomServiceException;

public interface ConverterService {

	public String covertToJson(String csvData) throws CustomServiceException;

	public String convertCsvFileToJson(MultipartFile file) throws CustomServiceException;

}
