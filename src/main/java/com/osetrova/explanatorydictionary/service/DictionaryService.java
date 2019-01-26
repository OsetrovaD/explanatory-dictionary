package com.osetrova.explanatorydictionary.service;

import com.osetrova.explanatorydictionary.dao.DictionaryDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryService {

    private DictionaryDao dao;

    public Map<String, Long> getAllExplanations() {
        Map<String, Long> result = dao.getAllFromOldDictionary();
        result.putAll(dao.getAllFromModernDictionary());

        return result;
    }

    public Map<String, Long> getAllExplanationsBySql() {
        return dao.getAllExplanationsBySql();
    }
}
