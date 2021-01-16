package com.apeshko.testing.template;

import java.util.HashMap;
import java.util.Map;

public class TemplateModel {
    private final Map<String, String> tags = new HashMap<>();

    public TemplateModel(Map<String, String> initialTags) {
        this.tags.putAll(initialTags);
    }
}
