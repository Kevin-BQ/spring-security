package com.app.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("('denyAll")
public class TestController {

    /*@GetMapping("/hello")
    //@PreAuthorize("permitAll")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/hello-security")
    //@PreAuthorize("hasAuthority('READ')")
    public String helloSecurity() {
        return "Hello Security";
    }

    @GetMapping("/hello-security2")
    //@PreAuthorize("hasAuthority('CREATE')")
    public String helloSecurity2() {
        return "Hello Security 2";
    }*/

    @GetMapping("/Get")
    @PreAuthorize("hasAuthority('READ')")
    public String hello() {
        return "Hello World - Get";
    }

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('CREATE') and hasRole('ADMIN')")
    public String post() {
        return "Hello World - Post";
    }


    @PutMapping("/put")
    @PreAuthorize("hasAuthority('UPDATE')")
    public String put() {
        return "Hello World - Put";
    }

    @DeleteMapping("/delete")
    @PreAuthorize("hasAuthority('DELETE')")
    public String delete() {
        return "Hello World - Delete";
    }


}
