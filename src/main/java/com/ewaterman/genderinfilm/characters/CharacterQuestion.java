package com.ewaterman.genderinfilm.characters;

import com.ewaterman.genderinfilm.common.BooleanAnswer;
import jakarta.persistence.*;
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
    @Column(name="id", nullable=false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="character_id", nullable=false)
    private Character character;

    @Enumerated(EnumType.STRING)
    @Column(name="question", nullable=false)
    private CharacterQuestionType question;

    @Enumerated(EnumType.STRING)
    @Column(name="answer", nullable=false)
    private BooleanAnswer answer;

    /**
     * In case the answer needs a longer explanation.
     */
    @Column(name="details")
    private String details;

}
