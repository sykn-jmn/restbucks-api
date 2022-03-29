package com.orangeandbronze.restbucks;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class LoginController {

    @GetMapping("/")
    public RepresentationModel apiRoot(){
        RepresentationModel rootResource = new RepresentationModel();
        rootResource.add(
                linkTo(methodOn(LoginController.class).apiRoot()).withSelfRel(),
                linkTo(methodOn(LoginController.class).login()).withRel("login")
        );
        return rootResource;
    }

    @GetMapping("login")
    public ResponseEntity<Void> login(){
        return ResponseEntity.status(200).build();
    }
}
