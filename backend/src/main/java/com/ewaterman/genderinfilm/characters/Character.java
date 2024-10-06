package com.ewaterman.genderinfilm.characters;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.ewaterman.genderinfilm.common.BooleanAnswer;
import com.ewaterman.genderinfilm.movies.Movie;

import java.util.List;

/**
 * Represents a character in a single film. If a character exists in multiple films they will
 * have multiple entries in this table, one per film. This greatly simplifies the logic for
 * managing characters but might cause slight inaccuracies in any reporting on the data.
 * This can be refactored in the future if needed.
 */
@Entity
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable=false)
    private Movie movie;

    @OneToMany(mappedBy = "character_question", cascade = CascadeType.ALL)
    private List<CharacterQuestion> questions;

    private CharacterType type;

    private String name;

    /**
     * Is the character named in the movie? (The credits don't count, it must be said in the movie.)
     * Return BooleanAnswer to stay consistent with all other question types.
     */
    public BooleanAnswer hasName() {
        // Don't assume that an empty value means there isn't a name. It might just not be filled in yet.
        if (StringUtils.isBlank(name)) {
            return BooleanAnswer.UNDEFINED;
        }

        if (CharacterUtil.DEFAULT_NAME_FOR_UNNAMED_CHARACTER.equals(name)) {
            return BooleanAnswer.NO;
        }

        return BooleanAnswer.YES;
    }
}