package com.apeshko.testing.template.impl;

import com.apeshko.testing.template.TagsMatcher;
import com.apeshko.testing.template.TemplateGenerator;
import com.apeshko.testing.template.TemplateModel;

import java.util.List;

public class DefaultTemplateGenerator implements TemplateGenerator {
    private TagsMatcher tagsMatcher;

    public DefaultTemplateGenerator(TagsMatcher tagsMatcher) {
        this.tagsMatcher = tagsMatcher;
    }

    @Override
    public String buildFromString(String templateContent, TemplateModel templateModel) {
        if (templateContent == null) {
            throw new IllegalArgumentException("template content should not be null");
        }

        List<String> tags = this.tagsMatcher.getAllTags(templateContent);

        if (tags.size() > 0 && templateModel == null) {
            throw new IllegalArgumentException("template content has tags but template model is missed");
        }

        for (String tag : tags) {
            String tagValue = templateModel.getValue(tag);

            if (tagValue == null) {
                throw new IllegalArgumentException("Some tag values are missed");
            }

            templateContent = templateContent.replaceAll("#\\{" + tag + "\\}", tagValue);
        }

        return templateContent;
    }
}
