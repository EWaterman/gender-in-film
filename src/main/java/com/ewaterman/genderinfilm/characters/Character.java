package com.ewaterman.genderinfilm.characters;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.*;

import com.ewaterman.genderinfilm.common.BooleanAnswer;
import com.ewaterman.genderinfilm.movies.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a character in a single film. If a character exists in multiple films they will
 * have multiple entries in this table, one per film. This greatly simplifies the logic for
 * managing characters but might cause slight inaccuracies in any reporting on the data.
 * This can be refactored in the future if needed.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="movie_id", nullable=false)
    private Movie movie;

    @OneToMany(mappedBy="character", cascade=CascadeType.ALL)
    private List<CharacterQuestion> questions = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name="type", nullable=false)
    private CharacterType type;

    @Column(name="name")
    private String name;

    /**
     * Is the character named in the movie? (The credits don't count, it must be said in the movie.)
     * Return BooleanAnswer to stay consistent with all other question types.
     */
    public BooleanAnswer hasName() {
        if (StringUtils.isBlank(name) || CharacterUtil.DEFAULT_NAME_FOR_UNNAMED_CHARACTER.equals(name)) {
            return BooleanAnswer.NO;
        }

        return BooleanAnswer.YES;
    }
}
