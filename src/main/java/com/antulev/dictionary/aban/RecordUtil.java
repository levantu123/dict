package com.antulev.dictionary.aban;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

import com.antulev.dictionary.model.Description;
import com.antulev.dictionary.model.Word;

public class RecordUtil {
	public static void buildWordFromRecord(Word word, CSVRecord record) {
	
		List<Description> desList = new ArrayList<>();
		String baseTextInData = record.get(0);
		String dataArray[] = baseTextInData.split(" ", 2);
		Description des = new Description();
		try {
			String baseText = dataArray[0];
			word.setBaseText(baseText);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
		try {
			String wordType = dataArray[1].split("\\(",2)[1].split("\\)",2)[0];
			des.setWordType(wordType);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
		try {
			String content = dataArray[1].split("\\(",2)[1].split("\\)",2)[1].replaceFirst(" ", "");
			des.setContent(content);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
		desList.add(des);
		word.setDescriptions(desList);
	}
}
