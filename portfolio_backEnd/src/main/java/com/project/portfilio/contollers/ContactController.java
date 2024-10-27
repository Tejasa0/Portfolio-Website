package com.project.portfilio.contollers;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.portfilio.model.Contact;
import com.project.portfilio.repository.ContactRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/portfolio/contact")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
    @Autowired
    private JavaMailSender emailSender;

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) throws MessagingException {
    	MimeMessage message = emailSender.createMimeMessage();
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);
	    helper.setTo(contact.getEmail().toString());
	    helper.setSubject("Confirmation");
	    helper.setText("Thank you for contacting me, I will be in touch with you soon");
//	    helper.setBcc("tejaspatila0@gmail.com");
//	    helper.addAttachment("Attachment", new File("C:\\Users\\USER\\Downloads\\f1.properties"));
	    emailSender.send(message);
        return contactRepository.save(contact);
    }
}

