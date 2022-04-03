package com.audiosharing.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/v")
@Controller
public class TestController {

  @GetMapping("")
  public String main() {
    return "test";
  }
}

