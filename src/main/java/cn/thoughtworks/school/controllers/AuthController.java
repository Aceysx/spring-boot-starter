package cn.thoughtworks.school.controllers;

import cn.thoughtworks.school.controllers.dto.AuthenticationRequest;
import cn.thoughtworks.school.controllers.dto.AuthenticationResponse;
import cn.thoughtworks.school.entities.User;
import cn.thoughtworks.school.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody AuthenticationRequest request
    ) {
        String token = service.register(User.builder().username(request.getUsername()).password(request.getPassword()).build());
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        String token = service.authenticate(User.builder().username(request.getUsername()).password(request.getPassword()).build());
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        // For stateless JWT, logout is primarily a client-side operation (deleting the token).
        // This endpoint can be used for any server-side cleanup if necessary.
        return ResponseEntity.ok().build();
    }
} 