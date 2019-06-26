package com.example.browserstack;

import java.util.HashMap;
import java.util.Map;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;

import com.browserstack.local.Local;
import net.serenitybdd.jbehave.SerenityStories;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

/**
 * Copied from BrowserStack sample code.
 */
public class BrowserStackSerenityTest extends SerenityStories
{
    static Local bsLocal;

    @BeforeStories
    public static void setUp() throws Exception
    {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null)
        {
            accessKey = (String) environmentVariables.getProperty("browserstack.key");
        }

        String environment = System.getProperty("environment");
        String key = "bstack_browserstack.local";
        boolean is_local = environmentVariables.getProperty(key) != null && environmentVariables.getProperty(key).equals("true");

        if (environment != null && !is_local)
        {
            key = "environment." + environment + ".browserstack.local";
            is_local = environmentVariables.getProperty(key) != null && environmentVariables.getProperty(key).equals("true");
        }

        if (is_local)
        {
            bsLocal = new Local();
            Map<String, String> bsLocalArgs = new HashMap<>();
            bsLocalArgs.put("key", accessKey);
            bsLocal.start(bsLocalArgs);
        }
    }

    @AfterStories
    public static void tearDown() throws Exception
    {
        if (bsLocal != null)
        {
            bsLocal.stop();
        }
    }
}
