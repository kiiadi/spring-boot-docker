package com.kiiadi.hello;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public final class HelloController {

    @GetMapping
    public String hello() {
        return doHello();
    }

    @GetMapping("/{dir}")
    public List<String> list(@PathVariable String dir) {
        try {
            return Arrays.asList(Objects.requireNonNull(new File("/" + dir).list()));
        } catch (Exception e) {
            return Stream.of(e.getStackTrace()).map(Object::toString).collect(Collectors.toList());
        }
    }

    private String doHello() {
        return "Hello containers world!";
    }
}
