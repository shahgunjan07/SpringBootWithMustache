package com.example.model.preparer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.example.model.preparer.dto.FormConstants;
import com.example.model.preparer.dto.FormMetaData;
import com.example.model.preparer.dto.FormRadioButton;
import com.example.model.preparer.dto.FormRadioOptions;

@Component
public class ModelPreparer {

	@Autowired
	private Environment env;
	
	/**
	 * Method used to prepare Radio Button element for UI form
	 * @param rootKey
	 * @return
	 */
	public FormRadioButton prepareFormRadio(String rootKey) {
		String radioId = readProperty(rootKey);
		
		FormRadioButton formRadio = FormRadioButton
										.builder()
										.radioId(radioId)
										.radioLabel(readProperty(radioId, FormConstants.ELEMENT_VALUE))
										.radioName(radioId)
										.radioOptions(
												readOptionIds(generateKey(radioId, FormConstants.ELEMENT_OPTIONS))
												.stream()
												.map(
														x -> FormRadioOptions
															.builder()
															.optionId(readProperty(x,FormConstants.ELEMENT_ID))
															.optionName(readProperty(x,FormConstants.ELEMENT_NAME))
															.optionValue(readProperty(x,FormConstants.ELEMENT_VALUE))
															.revealId(readProperty(x,FormConstants.ELEMENT_REVEALID))
															.build()
													)
												.collect(Collectors.toList())
												).build();
		
		return formRadio;
	}
	
	/**
	 * Method used to read radio options
	 * @param radioOptions
	 * @return
	 */
	private List<String> readOptionIds(String radioOptions) {
		return Arrays.asList(readProperty(radioOptions).split(","));
	}

	/**
	 * Method used to Prepare meta data for UI form
	 * 
	 * @return
	 */
	public FormMetaData prepareFormMetaData() {
		FormMetaData formMetaData = FormMetaData.builder()
				.title(readProperty(FormConstants.FORM_TITLE))
				.welcomeMessage(readProperty(FormConstants.FORM_WELCOME_MESSAGE))
				.build();
		return formMetaData;
	}

	/**
	 * Method used to retrieve value of given input key from resource bundle file
	 * 
	 * @param key
	 * @return
	 */
	private String readProperty(String key) {
		return env.getProperty(key);
	}
	
	/**
	 * Method used to retrieve value of given input key from resource bundle file
	 * 
	 * @param key
	 * @return
	 */
	private String readProperty(String prefix, String suffix) {
		return env.getProperty(generateKey(prefix, suffix));
	}
	
	/**
	 * Method used to generate key
	 * @param prefix
	 * @param suffix
	 * @return
	 */
	private String generateKey(String prefix, String suffix) {
		return prefix +"_" + suffix;
	}
	

}
