package com.apeshko.testing.template.impl;

import com.apeshko.testing.template.TagsMatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTagsMatcherTest {
    private final TagsMatcher tagsMatcher = new DefaultTagsMatcher();

    @ParameterizedTest
    @MethodSource("provideTemplatesWithTags")
    void getAllTags_shouldReturnAllTagsInTemplate(String inputTemplate, List expectedResult) {
        assertEquals(expectedResult, tagsMatcher.getAllTags(inputTemplate));
    }

    private static Stream<Arguments> provideTemplatesWithTags() {
        return Stream.of(
                Arguments.of("hello #{name} #{surname}", Arrays.asList("name", "surname")),
                Arguments.of("test", Arrays.asList()),
                Arguments.of("#{test} word #{test}", Arrays.asList("test"))
        );
    }

    private static Stream<Arguments> provideWrongArguments() {
        return Stream.of(
                Arguments.of(null, null)
        );
    }
}