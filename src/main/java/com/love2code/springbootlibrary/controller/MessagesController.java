package com.love2code.springbootlibrary.controller;

import com.love2code.springbootlibrary.entitiy.Message;
import com.love2code.springbootlibrary.requestmodels.AdminMessageRequest;
import com.love2code.springbootlibrary.service.MessagesService;
import com.love2code.springbootlibrary.utils.ExtractJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/messages")
public class MessagesController {

    private MessagesService messagesService;

    @Autowired
    public MessagesController(MessagesService messagesService) {
        this.messagesService = messagesService;
    }

    @GetMapping
    public List<Message> getAllMessagesByClosedFalse() {
        return messagesService.getAllMessagesByClosedFalse();
    }

    @PostMapping("/secure/add/message")
    public void postMessage(@RequestHeader(value="Authorization") String token,
                            @RequestBody Message messageRequest) {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        messagesService.postMessage(messageRequest, userEmail);
    }

    @PutMapping("/secure/admin/message")
    public void putMessage(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody AdminMessageRequest adminMessageRequest
    ) throws Exception {
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        String admin = ExtractJWT.payloadJWTExtraction(token, "\"userType\"");
        if (admin == null || !admin.equals("admin")) {
            throw new Exception("Administration page only.");
        }
        messagesService.putMessage(adminMessageRequest, userEmail);
    }
}
