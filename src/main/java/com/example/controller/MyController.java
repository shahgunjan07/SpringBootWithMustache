package com.example.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String loadWelcomePage(Model model,HttpServletRequest request, @RequestParam String test) {
		Enumeration<String> enumeration= request.getParameterNames();
		while(enumeration.hasMoreElements()) {
			String paramName = enumeration.nextElement();
			System.out.println("Request Parameter Name :"+paramName+" and Value :"+request.getParameter(paramName));
		}
		model.addAttribute("metaData", modelPreparer.prepareFormMetaData());
		model.addAttribute("formRadio", modelPreparer.prepareFormRadio(FormConstants.QUESTION1));
		return "/mustache/secondPage";
	}
	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, value = "/mustache/secondPage", produces = "application/json")
	public String loadSecondPage(Model model,HttpServletRequest request) {
		System.out.println("Inside Second Controller ....");
		Enumeration<String> enumeration= request.getParameterNames();
		while(enumeration.hasMoreElements()) {
			String paramName = enumeration.nextElement();
			System.out.println("Request Parameter Name :"+paramName+" and Value :"+request.getParameter(paramName));
		}
		model.addAttribute("metaData", modelPreparer.prepareFormMetaData());
		model.addAttribute("formRadio", modelPreparer.prepareFormRadio(FormConstants.QUESTION2));
		return "page2";
	}
	
}
