package com.converter.csvtojson.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.converter.csvtojson.exceptions.CustomServiceException;

@ControllerAdvice
public class CustomErrorController {

	@ExceptionHandler(CustomServiceException.class)
	public String handleError(CustomServiceException ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "view/error";
	}
}
