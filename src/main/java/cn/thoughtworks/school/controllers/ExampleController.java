package cn.thoughtworks.school.controllers;

import cn.thoughtworks.school.services.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private ExampleService exampleService;

    @GetMapping("")
    public ResponseEntity index() {
        return ResponseEntity.ok("Success!");
    }

    @GetMapping("api/examples/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity findOne(@PathVariable Long id) {
        return ResponseEntity.ok(exampleService.findById(id));
    }

    @GetMapping("api/admin/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity adminHello() {
        return ResponseEntity.ok("Hello, Admin!");
    }
}
