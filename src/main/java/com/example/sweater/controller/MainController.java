package com.example.sweater.controller;

import com.example.sweater.domians.Message;
import com.example.sweater.domians.User;
import com.example.sweater.domians.Zayavki;
import com.example.sweater.repos.MessageRepo;
import com.example.sweater.repos.ZayavkiRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ZayavkiRepos zayavkiRepos;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }


    @GetMapping("/user-custom")
    public String userCustom(Map<String, Object> model, User user) {
        // Iterable<Message> messages = messageRepo.findAll();

//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }


        Iterable<Zayavki> all = zayavkiRepos.findAll();
        model.put("messages", all);
        return "userCustom";
    }

    @GetMapping("/main")
    public String main(String filter, Model model, User user) {

        Iterable<Message> byUserId = messageRepo.findByUsersId(1L);
        // System.out.println(byUserId.size());

        model.addAttribute("messages", byUserId);
        // model.addAttribute("messages", messages);spring_session_attributes
//        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) {
        Message message = new Message(text, tag, user, user.getId());

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "redirect:/user";
    }

    @GetMapping("/user-messages/{user}")
    public String userMessges(
            @AuthenticationPrincipal User currentUser,
            @PathVariable User user,
            Model model,
            @RequestParam(required = false) Message message
    ) {
        Set<Message> messages = user.getMessages();

        model.addAttribute("messages", messages);
        model.addAttribute("message", message);
        model.addAttribute("isCurrentUser", currentUser.equals(user));

        return "userMessages";
    }

    @PostMapping("/user-messages/{user}")
    public String updateMessage(
            @AuthenticationPrincipal User currentUser,
            @PathVariable Long user,
            @RequestParam("id") Message message,
            @RequestParam("text") String text,
            @RequestParam("tag") String tag,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        if (message.getAuthor().equals(currentUser)) {
            if (!StringUtils.isEmpty(text)) {
                message.setText(text);
            }
            if (!StringUtils.isEmpty(tag)) {
                message.setTag(tag);
            }

            messageRepo.save(message);
        }

        return "redirect:/user-messages/" + user;
    }


    }
