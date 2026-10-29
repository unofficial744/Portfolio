package com.skilllab.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

// import ch.qos.logback.core.model.Model;
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("name", "Aditya Kumar");
        model.addAttribute("title", "Java Backend Devloper");
        model.addAttribute("tagline", "I build web application with Java and Spring Boot"
                + " and I'm looking for my first role as a Backend devloper");

        // ---- About ----
        model.addAttribute(
                "about",
                "I'm a final-year BCA student at SHEAT College of "
                        + "Engineering, Varanasi. I like building things that actually run, "
                        + "and I've spent the last year learning Java and Spring Boot properly.");

        model.addAttribute("location", "Varanasi, India");
        model.addAttribute("email", "adityaiam744@gmail.com");
        model.addAttribute("github", "https://github.com/unofficial744");
        model.addAttribute("linkedin", "https://linkedin.com/in/adityaiam744");
        model.addAttribute("resumeUrl", "https://drive.google.com/file/d/1WsMt0deO14iAzQ1dB5lmAi2YY74dVbvo/view?usp=drivesdk");

        return "index";
    }
}
