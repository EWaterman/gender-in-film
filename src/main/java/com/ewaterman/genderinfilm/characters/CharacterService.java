package com.ewaterman.genderinfilm.characters;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Optional<Character> findById(Long id) {
        return characterRepository.findById(id);
    }

    public Character save(Character character) {
        return characterRepository.save(character);
    }

    public Character update(Long id, Character character) {
        if (!characterRepository.existsById(id)) {
            throw new IllegalArgumentException("Character with id " + character + " does not exist");
        }

        return characterRepository.save(character);
    }

    public void delete(Long id) {
        characterRepository.deleteById(id);
    }
}
