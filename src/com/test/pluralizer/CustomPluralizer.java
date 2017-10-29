package com.test.pluralizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.jvnet.inflector.Noun;
import org.jvnet.inflector.Pluralizer;
import org.jvnet.inflector.Rule;
import org.jvnet.inflector.RuleBasedPluralizer;
import org.jvnet.inflector.rule.RegexReplacementRule;

public class CustomPluralizer {
	
	private List<Rule> customRules;
	private Pluralizer localPluralizer;
	
	public CustomPluralizer() {
		customRules = new ArrayList<>();
		customRules.add(new RegexReplacementRule("(?i)(.*)fish", "fishes"));
		customRules.add(new RegexReplacementRule("(?i)(.*)a", "an"));
		localPluralizer = new RuleBasedPluralizer(customRules, Locale.ENGLISH, Noun.pluralizer(Locale.ENGLISH));
	}
	
	public boolean isPluralOf(String originWord, String pluralWord) {
		return Noun.pluralOf(originWord).equalsIgnoreCase(pluralWord) ||
			Noun.pluralOf(originWord, localPluralizer).equalsIgnoreCase(pluralWord);
	}
	
	
	

}
