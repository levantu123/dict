package com.antulev.dictionary.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "wordMeta", types = { Word.class }) 
public interface WordMeta {
	String getId();
	String getBaseText();
}
