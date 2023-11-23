package com.zakia.users.restcontrollers;

import com.zakia.users.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class MailController {

    @Autowired
    private MailService mailService;


    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendEmail(@RequestBody Map<String, String> emailData) {
        String to = emailData.get("to");
        String subject = emailData.get("subject");
        String message = emailData.get("message");

        // Call the sendEmail method from your MailService
        mailService.sendEmail(to, message, subject);

        return "Email sent successfully: To=" + to + ", Subject=" + subject + ", Message=" + message;
    }

}
