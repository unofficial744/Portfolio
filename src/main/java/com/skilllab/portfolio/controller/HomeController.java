package com.skilllab.portfolio.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.skilllab.portfolio.model.Skill;

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


         List<Skill> skills = new ArrayList<>();
         skills.add(new Skill("HTML ", "Frontend"));
        skills.add(new Skill("CSS ", "Frontend"));
        skills.add(new Skill("JavaScript ", "Frontend"));
        skills.add(new Skill("Thymeleaf ", "Frontend"));

        skills.add(new Skill("Java ", "Backend"));
        skills.add(new Skill("Spring Boot ", "Backend"));
        skills.add(new Skill("Spring MVC ", "Backend"));
        skills.add(new Skill("Spring Data JPA ", "Backend"));
        skills.add(new Skill("REST APIs ", "Backend"));
        skills.add(new Skill("SQL ", "Backend"));

        skills.add(new Skill("Git & GitHub ", "Tools"));
        skills.add(new Skill("IntelliJ IDEA, VS Code ", "Tools"));
        skills.add(new Skill("Maven ", "Tools"));
        skills.add(new Skill("Postman ", "Tools"));

        Map<String, List<Skill>> skillsByCategory = new LinkedHashMap<>();

        for (Skill skill : skills) {

            // Create an empty list if the category does not exist.
            skillsByCategory.putIfAbsent(
                    skill.getCategory(),
                    new ArrayList<>()
            );
         skillsByCategory.get(skill.getCategory()).add(skill);
        }

         model.addAttribute("skillsByCategory", skillsByCategory);

        return "index";
    }
}
