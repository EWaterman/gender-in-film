package com.ewaterman.genderinfilm.characters;

/**
 * Enumerates the different types of questions that can be asked about a character.
 */
public enum CharacterQuestionType {

    /**
     * Does the character survive through the whole movie?
     */
    ALIVE_AT_END,

    /**
     * Is the character played by a transgender or gender non-conforming actor?
     */
    TRANS_ACTOR,

    /**
     * Is the character in multiple scenes?
     */
    IN_MULTIPLE_SCENES,

    /**
     * Is the character a villain or antagonist to the protagonists? Are they a murderer,
     * a criminal, or otherwise portrayed as morally wrong by the film?
     */
    VILLAINOUS,

    /**
     * Is the character's gender expression played off as a joke or otherwise not taken seriously?
     */
    IS_GENDER_JOKE,
}
