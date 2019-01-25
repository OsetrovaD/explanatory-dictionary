package com.osetrova.explanatorydictionary.dao;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryDao {

    private static final String MODERN_DICTIONARY_SELECT = "SELECT word, reference_id FROM explanatory_dictionary_storage.dictionary_1";
    private static final String OLD_DICTIONARY_SELECT = "SELECT word, reference_id FROM explanatory_dictionary_storage.dictionary_2";
    private JdbcTemplate template;

    public Map<String, Long> getAllFromOldDictionary() {
        return getExplanation(OLD_DICTIONARY_SELECT);
    }

    public Map<String, Long> getAllFromModernDictionary() {
        return getExplanation(MODERN_DICTIONARY_SELECT);
    }

    private Map<String, Long> getExplanation(String query) {
        return template.query(query, resultSet -> {
            Map<String, Long> explanations = new HashMap<>();
            while(resultSet.next()){
                explanations.put(resultSet.getString("word"), resultSet.getLong("reference_id"));
            }

            return explanations;
        });
    }
}
