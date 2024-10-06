package com.ewaterman.genderinfilm.reports;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.ewaterman.genderinfilm.common.BooleanAnswer;
import com.ewaterman.genderinfilm.characters.CharacterQuestionType;
import com.ewaterman.genderinfilm.movies.MovieQuestionType;

/**
 * Represents an aggregate of all data in the system for the purpose of reporting on it.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDto {
    /**
     * Maps the character questions to the count of their answers across all characters.
     *
     * Example value:
     * {
     *   "TRANS_ACTOR": {
     *     "YES": 3,
     *     "NO": 14,
     *     "UNCLEAR": 12,
     *   },
     *   ...
     * }
     */
    Map<CharacterQuestionType, Map<BooleanAnswer, Integer>> characterQuestionsCount;

    /**
     * Maps the movie questions to the count of their answers across all movies.
     *
     * Example value:
     * {
     *   "TRANS_WRITER": {
     *     "YES": 3,
     *     "NO": 14,
     *     "UNCLEAR": 12,
     *   },
     *   ...
     * }
     */
    Map<MovieQuestionType, Map<BooleanAnswer, Integer>> movieQuestionsCount;
}
