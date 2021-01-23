package com.apeshko.testing.template;

public interface TemplateGenerator {
    String buildFromString(String templateContent, TemplateModel templateModel);
}
