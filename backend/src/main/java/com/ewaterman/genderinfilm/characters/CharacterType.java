package com.ewaterman.genderinfilm.characters;

public enum CharacterType {

    /**
     * An explicitly transgender or gender non-conforming character. The character specifically identifies as such.
     */
    TRANS,

    /**
     * The character isn't explicitly identified as trans or gender non-conforming but has the possibility to be.
     * A common occurrence of this is a trans actor playing a character who isn't specifically mentioned as trans.
     *
     * Unfortunately, deciding whether a character is trans can be both intrusive and extremely subjective, however
     * it feels like a necessity if we want to be able to represent the full spectrum of characters/data.
     */
    MAYBE_TRANS,

    /**
     * A cisgender character performing gender non-conforming actions (ex: drag).
     */
    CIS_PERFORMING_TRANS,
}
