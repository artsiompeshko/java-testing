package com.apeshko.testing.template.impl;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 This is just to show test examples with filtered tags
 */

@RunWith(JUnitPlatform.class)
@SelectPackages("com.apeshko.testing.template.impl")
@IncludeTags("fast")
public class DefaultFastTemplateTestSuite {
}
