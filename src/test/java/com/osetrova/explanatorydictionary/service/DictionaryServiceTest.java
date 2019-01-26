package com.osetrova.explanatorydictionary.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DictionaryServiceTest {

    @Autowired
    private DictionaryService service;
    private static Map<String, Long> expectedResult = new HashMap<>();

    @BeforeClass
    public static void fillResultMap() {
        expectedResult.put("человек", 4L);
        expectedResult.put("самолет", 3L);
        expectedResult.put("абажур", 1L);
        expectedResult.put("кинотеатр", 2L);
        expectedResult.put("карусель", 10L);
        expectedResult.put("паровоз", 11L);
        expectedResult.put("музыка", 6L);
    }

    @Test
    public void checkGetAllExplanations() {
        Map<String, Long> allExplanations = service.getAllExplanations();
        assertEquals(allExplanations, expectedResult);
    }

    @Test
    public void checkGetAllExplanationsBySql() {
        Map<String, Long> allExplanations = service.getAllExplanationsBySql();
        assertEquals(allExplanations, expectedResult);
    }
}
