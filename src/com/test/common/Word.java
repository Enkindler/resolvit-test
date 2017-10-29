package com.test.common;

import com.google.gson.annotations.SerializedName;
import com.test.pluralizer.CustomPluralizer;

public class Word  implements Comparable<Word>{

	private String word;
	
	@SerializedName("sentence-indexes")
	private String locationList;
	
	private Integer totalOcurrences;
	
	public Word(String word, Integer location, Integer totalOcurrences) {
		this.word = word;
		this.locationList = "[" + location + "]";
		this.totalOcurrences = 1;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getLocationList() {
		return locationList;
	}

	public void setLocationList(String locationList) {
		this.locationList = locationList;
	}
	
	public void addLocationIndex(Integer locationIndex) {
		this.locationList = this.locationList + ", [" + locationIndex + "]";
	}

	public Integer getTotalOcurrences() {
		return totalOcurrences;
	}

	public void setTotalOcurrences(Integer totalOcurrences) {
		this.totalOcurrences = totalOcurrences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		CustomPluralizer customPluralizer = new CustomPluralizer();
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equalsIgnoreCase(other.word) && !customPluralizer.isPluralOf(this.word, other.word) &&
				!customPluralizer.isPluralOf(other.word, this.word))
			return false;
		return true;
	}

	@Override
	public int compareTo(Word o) {
		return this.word.compareToIgnoreCase(o.word);
	}

	
}
