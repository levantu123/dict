package com.antulev.dictionary;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service
@ConfigurationProperties
public class AppConfig {
	
	@Value("${dictionary.default.files}")
	private List<String> defaultFileDataList = new ArrayList<>();
	
	@Value("${dictionary.enableInit}")
	private boolean enableInit;

	public List<String> getDefaultFileDataList() {
		return defaultFileDataList;
	}

	public void setDefaultFileDataList(List<String> defaultFileDataList) {
		this.defaultFileDataList = defaultFileDataList;
	}

	public boolean isEnableInit() {
		return enableInit;
	}

	public void setEnableInit(boolean enableInit) {
		this.enableInit = enableInit;
	}
}
