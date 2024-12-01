package ru.vindur.grafana_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.OptionalLong;
import java.util.Random;
import java.util.stream.LongStream;

@RestController
public class MainController {

    @GetMapping("/test/first")
    public ResponseEntity<Long> get() {
        LongStream stream = LongStream.generate(() -> (long) (Math.random() * 1000_000_000));

        OptionalLong first = stream.limit(100_000_000)
                .sorted()
                .findFirst();

        Long result = first.orElse(1L);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/test/error")
    public ResponseEntity<String> error() {
        Random random = new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("Error");
        } else {
            return ResponseEntity.ok("Ok");
        }
    }
}
