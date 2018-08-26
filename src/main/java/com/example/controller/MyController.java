package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.preparer.ModelPreparer;
import com.example.model.preparer.dto.FormConstants;

@Controller
public class MyController {

	/**
	 * modelPreparer
	 */
	@Autowired
	private ModelPreparer modelPreparer;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value = "/mustache/welcomePage", produces = "application/json")
	public String loadWelcomePage(Model model) {
		model.addAttribute("metaData", modelPreparer.prepareFormMetaData());
		model.addAttribute("formRadio", modelPreparer.prepareFormRadio(FormConstants.QUESTION1));
		return "index";
	}
	
}
