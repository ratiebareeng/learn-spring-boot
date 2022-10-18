package com.example.validatingforminput.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

import com.example.validatingforminput.model.*;

@Controller
public class ValidationController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        // register routes
        registry.addViewController("/results")
                .setViewName("results");
    }

    // implement routes
    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "/form";
    }
    /*
      @Argument A bindingResult object so that you can test for and retrieve validation errors
     */
    @PostMapping("/")
    public String checkPersonInfo(@Valid @ModelAttribute("personForm") PersonForm personForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/form";
        }
        // no errors user is routed to the results page in
        // src/main/resources/templates/results.html
        return "redirect:/results";
    }
}
