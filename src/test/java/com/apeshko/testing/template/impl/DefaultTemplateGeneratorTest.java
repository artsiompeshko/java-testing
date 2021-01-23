package com.apeshko.testing.template.impl;

import com.apeshko.testing.template.TemplateGenerator;
import com.apeshko.testing.template.TemplateModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultTemplateGeneratorTest {
    private TemplateGenerator templateGenerator = new DefaultTemplateGenerator(new DefaultTagsMatcher());

    @ParameterizedTest
    @MethodSource("provideTemplatesWithTags")
    void buildFromString_ShouldReplaceTagsWithTheirValues(String inputTemplate, String expectedTemplate, TemplateModel templateModel) {
        assertEquals(expectedTemplate, this.templateGenerator.buildFromString(inputTemplate, templateModel));
    }

    @ParameterizedTest
    @MethodSource("provideTemplatesWithTagsValues")
    void buildFromString_ShouldAllowValuesLikeTags(String inputTemplate, String expectedTemplate, TemplateModel templateModel) {
        assertEquals(expectedTemplate, this.templateGenerator.buildFromString(inputTemplate, templateModel));
    }

    @ParameterizedTest
    @MethodSource("provideTemplatesWithEdgeCases")
    void buildFromString_ShouldCoverEdgeCases(String inputTemplate, String expectedTemplate, TemplateModel templateModel) {
        assertEquals(expectedTemplate, this.templateGenerator.buildFromString(inputTemplate, templateModel));
    }

    @ParameterizedTest
    @MethodSource("provideTemplatesWithInvalidArgs")
    void buildFromString_ShouldThrowsExceptionForInvalidArgs(String inputTemplate, TemplateModel templateModel) {
        assertThrows(IllegalArgumentException.class, () -> {
                this.templateGenerator.buildFromString(inputTemplate, templateModel);
        });
    }

    @Test
    void buildFromString_ShouldThrowsExceptionIfNotEnoughTagsValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                this.templateGenerator.buildFromString("test #{tag}", new TemplateModel(new HashMap<>()));
        });

        assertEquals("Some tag values are missed", exception.getMessage());
    }

    private static Stream<Arguments> provideTemplatesWithTags() {
        return Stream.of(
                Arguments.of("hello #{name}", "hello Artsiom", new TemplateModel(new HashMap<String, String>() {{
                    put("name", "Artsiom");
                }})),
                Arguments.of("hello #{name} #{name}", "hello Artsiom Artsiom", new TemplateModel(new HashMap<String, String>() {{
                    put("name", "Artsiom");
                }})),
                Arguments.of("hello #{name} #{surname}", "hello Artsiom Peshko", new TemplateModel(new HashMap<String, String>() {{
                    put("name", "Artsiom");
                    put("surname", "Peshko");
                }})),
                Arguments.of("", "", null)
        );
    }

    private static Stream<Arguments> provideTemplatesWithTagsValues() {
        return Stream.of(
                Arguments.of("hello #{name} #{surname}", "hello Artsiom #{tag}", new TemplateModel(new HashMap<String, String>() {{
                    put("name", "Artsiom");
                    put("surname", "#{tag}");
                }}))
        );
    }

    private static Stream<Arguments> provideTemplatesWithEdgeCases() {
        return Stream.of(
                Arguments.of("", "", null)
        );
    }

    private static Stream<Arguments> provideTemplatesWithInvalidArgs() {
        return Stream.of(
                Arguments.of(null, null)
        );
    }
}