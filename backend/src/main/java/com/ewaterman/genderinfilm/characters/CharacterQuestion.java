package com.ewaterman.genderinfilm.characters;

import com.ewaterman.genderinfilm.common.BooleanAnswer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Represents a single question pertaining to a character.
 */
@Entity
@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterQuestion {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "character_id", nullable=false)
    private Character character;

    private CharacterQuestionType question;
    private BooleanAnswer answer;

    /**
     * In case the answer needs a longer explanation.
     */
    private String details;

}
