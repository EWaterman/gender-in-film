package com.ewaterman.genderinfilm.reports;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

import com.ewaterman.genderinfilm.characters.CharacterQuestion;
import com.ewaterman.genderinfilm.characters.CharacterQuestionType;
import com.ewaterman.genderinfilm.common.BooleanAnswer;
import com.ewaterman.genderinfilm.movies.MovieQuestion;
import com.ewaterman.genderinfilm.movies.MovieQuestionType;
import com.ewaterman.genderinfilm.characters.CharacterQuestionRepository;
import com.ewaterman.genderinfilm.movies.MovieQuestionRepository;

@Service
public class ReportService {

    private final MovieQuestionRepository movieQuestionRepository;
    private final CharacterQuestionRepository characterQuestionRepository;

    public ReportService(MovieQuestionRepository movieQuestionRepository,
                         CharacterQuestionRepository characterQuestionRepository) {
        this.movieQuestionRepository = movieQuestionRepository;
        this.characterQuestionRepository = characterQuestionRepository;
    }

    /**
     * Built and return the primary report on all data.
     */
    public ReportDto generatePrimaryReport() {
        return ReportDto.builder()
                .movieQuestionsCount(buildMovieQuestionsCount())
                .characterQuestionsCount(buildCharacterQuestionsCount())
                .build();
    }

    private Map<MovieQuestionType, Map<BooleanAnswer, Integer>> buildMovieQuestionsCount() {

        // Loop all the questions and get a total count of all of their answers.
        Map<MovieQuestionType, Map<BooleanAnswer, Integer>> movieQuestionsCount = new HashMap<>();
        for (MovieQuestion question : movieQuestionRepository.findAll()) {
            Map<BooleanAnswer, Integer> answersCount = movieQuestionsCount.computeIfAbsent(
                    question.getQuestion(), key -> new HashMap<>());

            BooleanAnswer answer = question.getAnswer();
            answersCount.put(answer, answersCount.getOrDefault(answer, 0) + 1);
        }

        return movieQuestionsCount;
    }

    private Map<CharacterQuestionType, Map<BooleanAnswer, Integer>> buildCharacterQuestionsCount() {

        // Loop all the questions and get a total count of all of their answers.
        Map<CharacterQuestionType, Map<BooleanAnswer, Integer>> characterQuestionsCount = new HashMap<>();
        for (CharacterQuestion question : characterQuestionRepository.findAll()) {
            Map<BooleanAnswer, Integer> answersCount = characterQuestionsCount.computeIfAbsent(
                    question.getQuestion(), key -> new HashMap<>());

            BooleanAnswer answer = question.getAnswer();
            answersCount.put(answer, answersCount.getOrDefault(answer, 0) + 1);
        }

        return characterQuestionsCount;
    }
}
