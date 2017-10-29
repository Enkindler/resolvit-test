package com.test.main;

import static com.test.constants.Constants.TEST_PARRAGRAPH;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.test.common.Word;

public class Main {
	
	public static void main(String args[]) {
		List<String> wordIgnoreList = Arrays.asList("A", "AN", "THE", "AND", "OF", "IN", "BE", "ALSO","AS");
		List<Word> processedWordList;
		System.out.println("Input text: " + TEST_PARRAGRAPH);
		System.out.println("Processing, please wait...");
		
		WordProcessor wordProcessor = new WordProcessor();
		wordProcessor.setWordIgnoreList(wordIgnoreList);
		wordProcessor.processText(TEST_PARRAGRAPH);
		processedWordList = wordProcessor.getProcessedWords();
		Collections.sort(processedWordList);
		
		
		Map<String, List<Word>> resultMap = new HashMap<>();
		resultMap.put("result", processedWordList);
		Gson gson = new Gson();
		
		System.out.println("Processed result: ");
		System.out.println(gson.toJson(resultMap));
		
	}
	
	

}
