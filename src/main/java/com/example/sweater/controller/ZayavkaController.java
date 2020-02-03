package com.example.sweater.controller;

import com.example.sweater.domians.Zayavki;
import com.example.sweater.repos.ZayavkiRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ZayavkaController {
    @Autowired

    private ZayavkiRepos zayavkiRepos;

    @GetMapping("/zayavki")
    public String zayavki(Map<String,Object> model) {

        Iterable<Zayavki> zayavkis = zayavkiRepos.findAll();
        model.put("messages", zayavkis);


        return "zayavki";
    }

    @PostMapping("/zayavki")
    public String add(
            @RequestParam String otdel,@RequestParam String problema, String number, String vremya, Map<String, Object> model
    ) {
        Zayavki zayavki = new Zayavki(otdel, problema, number, vremya);

        zayavkiRepos.save(zayavki);

        Iterable<Zayavki> zayavkis = zayavkiRepos.findAll();
        model.put("messages", zayavkis);

        return "redirect:/zayavki";
    }
}