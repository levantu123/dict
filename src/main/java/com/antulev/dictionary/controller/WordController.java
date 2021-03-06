package com.antulev.dictionary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.antulev.dictionary.repository.WordRepository;

@RestController
@RequestMapping(value="/words")
@CrossOrigin(origins = "http://localhost:4200")
public class WordController {
	
	@Autowired
	WordRepository wordRepository;
	
}
