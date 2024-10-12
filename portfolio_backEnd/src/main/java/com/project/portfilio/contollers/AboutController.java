package com.project.portfilio.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.portfilio.model.About;
import com.project.portfilio.repository.AboutRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/portfolio/about")
public class AboutController {
    @Autowired
    private AboutRepository aboutRepository;

    @GetMapping
    public About getAboutInfo() {
    	List<About>li=aboutRepository.findAll();
        return li.get(0);
    }

    @PostMapping
    public About createAbout(@RequestBody About about) {
        return aboutRepository.save(about);
    }
}

