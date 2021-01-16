package com.apeshko.testing.template.impl;

import com.apeshko.testing.template.TagsMatcher;
import com.apeshko.testing.template.TemplateGenerator;
import com.apeshko.testing.template.TemplateModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
   This is just to show test examples with mocked values
 */
@ExtendWith(MockitoExtension.class)
class DefaultTemplateGeneratorTestWithMock {
    @Mock
    TagsMatcher mockedTagsMatcher;

    private TemplateGenerator templateGenerator;

    @BeforeEach
    void setUp() {
        templateGenerator = new DefaultTemplateGenerator(mockedTagsMatcher);
    }

    @Test
    @Tag("fast")
    void buildFromString_ShouldReplaceTags() {
        // given
        String inputTemplate = "Test #{tag}";
        when(mockedTagsMatcher.getAllTags(inputTemplate)).thenReturn(Arrays.asList("tag"));

        // when
        String actualResult = templateGenerator.buildFromString(inputTemplate, new TemplateModel(new HashMap<String, String>() {{
            put("tag", "value");
        }}));

        // then
        assertEquals("Test value", actualResult);
    }
}