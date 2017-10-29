package com.test.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.common.Word;

public class WordProcessor {
	
	private List<String> wordIgnoreList;
	private List<Word> localWordList = new ArrayList<>();
	

	public void processText(String text) {
		Integer sentenceCounter = 0;
		List<String> sentenceList = Arrays.asList(text.split("\\."));
		
		for(String sentence : sentenceList) {
			List<String> wordList = Arrays.asList(sentence.trim().replaceAll("[\\.,\\[\\]\\{\\}\":]", "").split("\\s"));
			processSentences(wordList, sentenceCounter);
			sentenceCounter++;
		}
	}
	
	private void processSentences(List<String> wordList, Integer sentenceIndex) {
		for(String word : wordList) {
			if(!isIgnoredWord(word)) {
				Word newWord = new Word(word, sentenceIndex, 1);
				int index = localWordList.indexOf(newWord);
				if(index >= 0) {
					Word tmpWord = localWordList.get(index); 
//					tmpWord.getLocationList().add(sentenceIndex);
					tmpWord.addLocationIndex(sentenceIndex);
					tmpWord.setTotalOcurrences(tmpWord.getTotalOcurrences() + 1);
				}
				else {
					localWordList.add(newWord);
				}
			}
		}
	}
	
	
	private boolean isIgnoredWord(String word) {
		return wordIgnoreList.contains(word.toUpperCase().trim());
	}
	
	
	public void setWordIgnoreList(List<String> wordIgnoreList) {
		this.wordIgnoreList = (wordIgnoreList != null) ? wordIgnoreList : new ArrayList<String>(); 
	}
	
	public List<Word> getProcessedWords() {
//		return new ArrayList<>(wordMap.values());
		return localWordList;
	}
}
