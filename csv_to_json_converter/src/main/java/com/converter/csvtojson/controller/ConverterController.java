package com.converter.csvtojson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.converter.csvtojson.exceptions.CustomServiceException;
import com.converter.csvtojson.service.ConverterService;

@Controller
public class ConverterController {

	@Autowired
	private ConverterService converterService;

	@GetMapping("/")
	public String home() {
		return "view/index";
	}

	@PostMapping("/csvdatatojson")
	public String csvToJson(Model model, @RequestParam("data") String csvData) throws CustomServiceException {
		model.addAttribute("jsons", converterService.covertToJson(csvData));
		return "view/index";
	}

	@PostMapping("/csvfiletojson")
	public String csvFileToJson(Model model, @RequestParam MultipartFile file) throws CustomServiceException {
		model.addAttribute("jsons", converterService.convertCsvFileToJson(file));
		return "view/index";
	}

}
