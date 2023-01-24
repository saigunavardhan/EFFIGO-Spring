package com.Springbootlearning.firstrestapi.Survey;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	@Test
	void jsonAssert_learnBasics() throws JSONException{
	String ExpectedOutcome="""
				{
			"id": "Question1",
			"description": "Most Popular Cloud Platform Today",
			"options": [
			"AWS",
			"Azure",
			"Google Cloud",
			"Oracle Cloud"
			],
			"correctAnswer": "AWS"
			}
			""";
	
	String actualOutcome ="""
				{
			"id": "Question1",
			"description": "Most Popular Cloud Platform Today",
			"options": [
			"AWS",
			"Azure",
			"Google Cloud",
			"Oracle Cloud"
			],
			"correctAnswer": "AWS"
			}
			""";
	
	JSONAssert.assertEquals(ExpectedOutcome, actualOutcome,true);
}
}