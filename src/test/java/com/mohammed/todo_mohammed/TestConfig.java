package com.mohammed.todo_mohammed;

import cucumber.api.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
        classes = {TodoMohammedApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestConfig {
    @Before
    public void prepareCucumberTestsContext(){
    }
}
