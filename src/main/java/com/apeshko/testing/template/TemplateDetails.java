package com.apeshko.testing.template;

public class TemplateDetails {
    private TemplateGenerator templateGenerator;
    private TemplateValidator templateValidator;
    private String templateContent;

    public TemplateDetails(TemplateGenerator templateGenerator, TemplateValidator templateValidator, String templateContent) {
        this.templateGenerator = templateGenerator;
        this.templateValidator = templateValidator;
        this.templateContent = templateContent;
    }

    public TemplateGenerator getTemplateGenerator() {
        return templateGenerator;
    }

    public void setTemplateGenerator(TemplateGenerator templateGenerator) {
        this.templateGenerator = templateGenerator;
    }

    public TemplateValidator getTemplateValidator() {
        return templateValidator;
    }

    public void setTemplateValidator(TemplateValidator templateValidator) {
        this.templateValidator = templateValidator;
    }

    public String getTemplateContent() {
        return templateContent;
    }

    public void setTemplateContent(String templateContent) {
        this.templateContent = templateContent;
    }
}
