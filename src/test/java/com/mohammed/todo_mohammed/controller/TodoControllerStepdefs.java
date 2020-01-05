package com.mohammed.todo_mohammed.controller;

import com.mohammed.todo_mohammed.repo.TodoRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


public class TodoControllerStepdefs {

    private final TodoController todoController;
    private final TodoRepo todoRepo;
    private final TestRestTemplate testRestTemplate;
    private final HttpHeaders httpHeaders;

    public TodoControllerStepdefs(TodoController todoController, TodoRepo todoRepo, TestRestTemplate testRestTemplate) {
        this.todoController = todoController;
        this.todoRepo = todoRepo;
        this.testRestTemplate = testRestTemplate;



        // setup headers
        this.httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        httpHeaders.add(HttpHeaders.ACCEPT_LANGUAGE, "en");

    }


    @Given("Execute todo method")
    public void executeTodoMethod() {
//        System.out.println(this.todoRepo.findAll());
        assertThat(this.todoRepo.findAll()).isNotNull();
    }

    @When("send json object with {string} : {string}")
    public void sendJsonObjectWith(String item, String content) {
        String todo_item = "random content";
        String path = "/todo";
        String requestBody = String.format("{ \"%s\": \"%s\" }",item, content);

        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity responseEntity = testRestTemplate.postForEntity(path, httpEntity, Object.class, Collections.emptyMap());

        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
    }

    @Then("The response should be the same object with generated id")
    public void theResponseShouldBeTheSameObjectWithGeneratedId() {

        String path = "/todo/1";
        String requestBody = String.format("{\"item_id\":1,\"item_content\":\"random content\",\"important\":false}");

        HttpEntity<String> httpEntity = new HttpEntity<>(requestBody, httpHeaders);
        ResponseEntity responseEntity = testRestTemplate.getForEntity(path , String.class );

        assertThat(responseEntity.getBody().toString()).isEqualTo(requestBody);
    }
}
