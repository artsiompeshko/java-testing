package com.apeshko.testing.template;

public class TemplateDetails {
    private TemplateGenerator templateGenerator;
    private String templateContent;

    public TemplateDetails(TemplateGenerator templateGenerator, String templateContent) {
        this.templateGenerator = templateGenerator;
        this.templateContent = templateContent;
    }

    public TemplateGenerator getTemplateGenerator() {
        return templateGenerator;
    }

    public void setTemplateGenerator(TemplateGenerator templateGenerator) {
        this.templateGenerator = templateGenerator;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }
}
