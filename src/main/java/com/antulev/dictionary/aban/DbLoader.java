package com.antulev.dictionary.aban;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.antulev.dictionary.AppConfig;
import com.antulev.dictionary.model.Description;
import com.antulev.dictionary.model.Word;
import com.antulev.dictionary.repository.WordRepository;

@Service
public class DbLoader {
	
	@Autowired
	WordRepository wordRepository;
	
	@Autowired
	AppConfig appConfig;
	
	public void init() throws FileNotFoundException, IOException {
		if(appConfig.isEnableInit()) {
			for(String fileName: appConfig.getDefaultFileDataList()) {
				addDataFile(fileName);
				System.out.println("Completed file: "+ fileName);
			}
		}	
	}
	
	@Async
	public void addDataFile(String fileName) throws FileNotFoundException, IOException {
		Reader in = new FileReader(new ClassPathResource(fileName).getFile());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
		Word lastword = null;
		for (CSVRecord record : records) {
			Word word = new Word();
			RecordUtil.buildWordFromRecord(word, record);
			if(lastword == null) {
				lastword = word;
				continue;
			}
			if(word.getBaseText().equals(lastword.getBaseText())) {
				List<Description> desList = lastword.getDescriptions();
				desList.addAll(word.getDescriptions());
				lastword.setDescriptions(desList);
			}else {
				wordRepository.save(lastword);
				lastword = word;
			}
		}
	}
	
	public void clean(){
		if(appConfig.isEnableInit()) {
			wordRepository.deleteAll();
		}	
	}
}
