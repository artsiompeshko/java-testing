package com.apeshko.testing.template.impl;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestExecutionLoggerToFile implements TestWatcher, AfterAllCallback {
    private final Path path = Paths.get("src/test/java/com/apeshko/testing/template/impl/test-result.txt");
    private final List<String> testResults = new ArrayList<>();

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        testResults.add("Test Disabled for test " + context.getDisplayName());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        testResults.add("Test Successful for test " + context.getDisplayName());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        testResults.add("Test Aborted for test " + context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        testResults.add("Test Failed for test " + context.getDisplayName());
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        Files.write(path, String.join("\n", testResults).getBytes());
    }
}