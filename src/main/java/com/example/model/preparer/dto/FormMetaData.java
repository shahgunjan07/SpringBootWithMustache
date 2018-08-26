package com.example.model.preparer.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FormMetaData {
	private String title;
	private String welcomeMessage;

	@Override
	public String toString() {
		return "FormMetaData [title=" + title + ", welcomeMessage=" + welcomeMessage + "]";
	}

}
