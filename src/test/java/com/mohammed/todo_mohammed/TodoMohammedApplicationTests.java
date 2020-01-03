//package com.mohammed.todo_mohammed;
//
//import com.mohammed.todo_mohammed.controller.TodoController;
//import com.mohammed.todo_mohammed.model.Todo;
//import com.mohammed.todo_mohammed.repo.TodoRepo;
//import com.mohammed.todo_mohammed.service.TodoService;
//import io.cucumber.java.en.*;
//import org.junit.jupiter.api.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.http.*;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//class TodoMohammedApplicationTests {
//
//    @LocalServerPort
//    int port;
//
//    private Logger logger = LoggerFactory.getLogger(getClass());
//
//    @Test
//    void contextLoads() {
//    }
//
//
//    @Test
//    public void testRestController() {
//        TestRestTemplate testRestTemplate = new TestRestTemplate();
//        String body = "{\"item_id\":1,\"item_content\":null}";
//        ResponseEntity<String> stringResponseEntity = testRestTemplate.getForEntity("http://localhost:" + port + "/todo/1", String.class);
//        stringResponseEntity.getBody();
//        logger.info(stringResponseEntity.getBody().toString());
//        assertThat(stringResponseEntity.getBody()).isEqualTo(body);
////        assertEquals("You have something wring", HttpStatus.OK, stringResponseEntity.getStatusCode());
////        assertNotNull("", stringResponseEntity);
//
//    }
//}
//
