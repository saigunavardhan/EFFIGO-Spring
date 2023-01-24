package com.Springbootlearning.firstrestapi.Survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SurveyResourcesIT {
	// http://localhost:RANDOM_PORT/Surveys/Survey1/questions/Question1

	String str = """
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

	//

	private static String SPECIFIC_QUESTION_URL = "/Surveys/Survey1/questions/Question1";
	@Autowired
	private TestRestTemplate temp;

	@Test
	void retrieveSpecQuestions_basicScenario() throws JSONException {
		ResponseEntity<String> respEntity = temp.getForEntity(SPECIFIC_QUESTION_URL, String.class);
		// System.out.println(respEntity.getBody());
		// System.out.println(respEntity.getHeaders());

		String ExpectedOutcome = """
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

		// Status of Response is it 200
		// [Content-Type:"application/json"
		assertTrue(respEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json",respEntity.getHeaders().get("Content-Type").get(0));
		
		JSONAssert.assertEquals(ExpectedOutcome, respEntity.getBody(), false);

	}
}
