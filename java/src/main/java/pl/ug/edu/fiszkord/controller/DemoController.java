package pl.ug.edu.fiszkord.controller;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ug.edu.fiszkord.service.UserService;

import java.security.Principal;

@RestController
@RequestMapping("/api/check")
@Hidden
@RequiredArgsConstructor
public class DemoController {

  private final UserService service;

  @GetMapping
  public ResponseEntity<String> sayHello(Principal connectedUser) {
    return ResponseEntity.ok("Obserwujemy Cię, "+service.getName(connectedUser));
  }

}
