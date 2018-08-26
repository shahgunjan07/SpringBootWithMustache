package com.example.model.preparer.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FormRadioOptions {

	private String optionName;

	private String optionValue;

	private String optionId;

	private String revealId;


	@Override
	public String toString() {
		return "FormRadioOptions [optionName=" + optionName + ", optionValue=" + optionValue + ", optionId=" + optionId
				+ ", revealId=" + revealId + "]";
	}

}
