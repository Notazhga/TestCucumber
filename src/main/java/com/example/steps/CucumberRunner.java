package com.example.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

        @RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features")
public class CucumberRunner {
}