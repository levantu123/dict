package com.antulev.dictionary.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Word {
	
	@Id
	private String id;
	private String baseText;
	private List<Description> descriptions;
	private List <String> examples;
	private List <String> synonyms;
	private List <String> antonyms;

	public String getBaseText() {
		return baseText;
	}
	public void setBaseText(String baseText) {
		this.baseText = baseText;
	}
	
	public List<String> getExamples() {
		return examples;
	}
	public void setExamples(List<String> examples) {
		this.examples = examples;
	}
	public List<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(List<String> synonyms) {
		this.synonyms = synonyms;
	}
	public List<String> getAntonyms() {
		return antonyms;
	}
	public void setAntonyms(List<String> antonyms) {
		this.antonyms = antonyms;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	public List<Description> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<Description> descriptions) {
		this.descriptions = descriptions;
	}
}
