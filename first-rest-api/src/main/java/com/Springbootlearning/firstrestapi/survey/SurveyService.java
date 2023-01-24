package com.Springbootlearning.firstrestapi.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList();

	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);

	}

	public List<Survey> retrieveAllSurveys() {
		return surveys;
	}

	public Survey retrieveSurveybyId(String SurveyId) {
		Predicate<? super Survey> predicate = survey -> survey.getId().equalsIgnoreCase(SurveyId);
		Optional<Survey> opsurvey = surveys.stream().filter(predicate).findFirst();
		if (opsurvey.isEmpty()) {
			return null;
		}
		return opsurvey.get();

	}

	public List<Question> retrieveAllQuestions(String SurveyId) {
		Survey sur = retrieveSurveybyId(SurveyId);

		if (sur == null)
			return null;
		return sur.getQuestions();
	}

	public Question retrieveSpecQuestions(String SurveyId, String questionId) {

		List<Question> surveyquestions = retrieveAllQuestions(SurveyId);
		if (surveyquestions == null)
			return null;

		Optional<Question> que = surveyquestions.stream().filter(q -> q.getId().equalsIgnoreCase(questionId))
				.findFirst();

		if (que.isEmpty())
			return null;

		return que.get();

	}

	public String addNewQuestion(String SurveyId, Question ques) {
		List<Question> questions = retrieveAllQuestions(SurveyId);
		ques.setId(generateRandom());
		questions.add(ques);
		return ques.getId();
		}

	private String generateRandom() {
		SecureRandom secureRandom = new SecureRandom();
		String randomId= new BigInteger(32, secureRandom).toString();
		return randomId;
	}
	
	public String deleteSpecQuestions(String SurveyId, String questionId) {

		List<Question> surveyquestions = retrieveAllQuestions(SurveyId);
		if (surveyquestions == null)
			return null;

		Predicate<? super Question> predicate = q->q.getId().equalsIgnoreCase(questionId);
		boolean removed = surveyquestions.removeIf(predicate);
		if(!removed) 
			return null;
		
		return questionId;

	}

	public void UpdateSpecQuestions(String SurveyId, String questionId, Question question) {
		List<Question> questions = retrieveAllQuestions(SurveyId);
		questions.removeIf(q->q.getId().equalsIgnoreCase(questionId));
		questions.add(question);
	}

		
	}
 
