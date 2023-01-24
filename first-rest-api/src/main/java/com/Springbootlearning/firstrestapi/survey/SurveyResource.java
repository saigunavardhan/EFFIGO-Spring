package com.Springbootlearning.firstrestapi.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

	private SurveyService surveyservice;

	public SurveyResource(SurveyService surveyservice) {
		super();
		this.surveyservice = surveyservice;
	}

	@RequestMapping("/Surveys")
	public List<Survey> retrieveAllSurveys() {
		return surveyservice.retrieveAllSurveys();
	}

	@RequestMapping("/Surveys/{SurveyId}")
	public Survey retrieveSurveybyId(@PathVariable String SurveyId) {
		Survey survey = surveyservice.retrieveSurveybyId(SurveyId);

		if (survey == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return survey;

	}

	@RequestMapping("/Surveys/{SurveyId}/questions")
	public List<Question> retrieveAllQuestions(@PathVariable String SurveyId) {
		List<Question> questions = surveyservice.retrieveAllQuestions(SurveyId);

		if (questions == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return questions;

	}

	@RequestMapping("/Surveys/{SurveyId}/questions/{questionId}")
	public Question retrieveSpecQuestions(@PathVariable String SurveyId, @PathVariable String questionId) {
		Question question = surveyservice.retrieveSpecQuestions(SurveyId, questionId);

		if (question == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return question;

	}

	@RequestMapping(value = "/Surveys/{SurveyId}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewQuestion(@PathVariable String SurveyId, @RequestBody Question ques) {

		String questionId = surveyservice.addNewQuestion(SurveyId, ques);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId)
				.toUri();
		return ResponseEntity.created(location).build();

	}

	@RequestMapping(value = "/Surveys/{SurveyId}/questions/{questionId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteSpecQuestions(@PathVariable String SurveyId, @PathVariable String questionId) {
		surveyservice.deleteSpecQuestions(SurveyId, questionId);
		return ResponseEntity.noContent().build();
	}


	@RequestMapping(value = "/Surveys/{SurveyId}/questions/{questionId}", method = RequestMethod.PUT)
	public ResponseEntity<Object> UpdateSpecQuestions(@PathVariable String SurveyId, @PathVariable String questionId, @RequestBody Question question) {
		surveyservice.UpdateSpecQuestions(SurveyId, questionId, question);
		return ResponseEntity.noContent().build();
	}
}
