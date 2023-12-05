package com.example.streamspringexample.controller;

import com.example.streamspringexample.localOpenAi.MyOpenAiClient;
import io.reactivex.Flowable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final MyOpenAiClient aiClient;

    public SimpleController(MyOpenAiClient aiClient) {
        this.aiClient = aiClient;
    }

    @CrossOrigin
    @GetMapping("/ai/simple")
    public String completion(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message) {
        return aiClient.generate(message) + "\n";
    }


    @CrossOrigin
    @GetMapping(path = "/ai/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flowable<String> streamCompletion(@RequestParam(value = "message", defaultValue = "Tell me a very long joke") String message) {
        return aiClient.generateStream(message);
    }
}
