package com.example.model.preparer.dto;

import java.util.List;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FormRadioButton {
	
	private String radioId;
	
	private String radioName;
	
	private String radioLabel;
	
	private List<FormRadioOptions> radioOptions;

	
	@Override
	public String toString() {
		return "FormRadioButton [radioId=" + radioId + ", radioName=" + radioName + ", radioLabel=" + radioLabel
				+ ", radioOptions=" + radioOptions + "]";
	}
	
	
	
}
