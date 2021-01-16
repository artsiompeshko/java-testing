package com.apeshko.testing.template.impl;

import com.apeshko.testing.template.TagsMatcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultTagsMatcher implements TagsMatcher {
    private static final Pattern TAG_REGEX = Pattern.compile("#\\{(.+?)\\}", Pattern.DOTALL);

    @Override
    public List<String> getAllTags(String templateContent) {
        if (templateContent == null) {
            throw new IllegalArgumentException("template content should not be null");
        }

        final Set<String> tags = new HashSet<>();
        final Matcher matcher = TAG_REGEX.matcher(templateContent);

        while (matcher.find()) {
            tags.add(matcher.group(1));
        }

        return new ArrayList<>(tags);
    }
}
