package com.converter.csvtojson.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.converter.csvtojson.exceptions.CustomServiceException;
import com.converter.csvtojson.service.ConverterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ConverterServiceImpl implements ConverterService {
	ObjectMapper objMapper = new ObjectMapper();

	@Override
	public String covertToJson(String csvData) throws CustomServiceException {
		List<String[]> columnList = new ArrayList<>();
		if (!isValidCSV(csvData, columnList))
			throw new CustomServiceException("Invalid CSV.");

		try {
			return objMapper.writeValueAsString(columnList);
		} catch (JsonProcessingException e) {
			throw new CustomServiceException(e.getMessage());
		}

	}

	private boolean isValidCSV(String csvData, List<String[]> columnList) {

		boolean isValidCsv = true;
	    csvData = csvData.replace("\r", "");
		String[] lines = csvData.split("\n");

		if (lines.length > 1) {
			for (String line : lines) {
				String[] columns = line.split(",");

				if (columnList.size() > 0) {
					isValidCsv = columns.length != columnList.get(0).length ? false : true;
					if (!isValidCsv)
						return false;
				}
				columnList.add(columns);
			}
		}
		return true;
	}

	@Override
	public String convertCsvFileToJson(MultipartFile file) throws CustomServiceException {
		if (file.isEmpty()) {
			throw new CustomServiceException("Please select a file to upload");
		}

		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			List<String[]> columnList = new ArrayList<>();
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}

			if (!isValidCSV(sb.toString(), columnList))
				throw new CustomServiceException("Invalid CSV.");

			try {
				return objMapper.writeValueAsString(columnList);
			} catch (JsonProcessingException e) {
				throw new CustomServiceException(e.getMessage());
			}

		} catch (IOException e) {
			throw new CustomServiceException(e.getMessage());
		}

	}

}
