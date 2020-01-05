package com.example.d2emo.Controller;

import com.example.d2emo.dto.AccessTokendto;
import com.example.d2emo.dto.Giteeuserinfo;
import com.example.d2emo.provider.GitProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Author {

    @Autowired
    private GitProvider gitprovider;

    @Value("${gitee.client.id}")
    private String client_id;
    @Value("${gitee.client.secret}")
    private String client_secret;
    @Value("${gitee.redirect.uri}")
    private String redirect_uri;

    @GetMapping("/callback")
    public String callback(@RequestParam(value = "code", required = true, defaultValue = "no") String code,
            @RequestParam(value = "state", required = false, defaultValue = "0") String state, Model model) {

        AccessTokendto accesstoken = new AccessTokendto();

        accesstoken.setClient_id(client_id);
        accesstoken.setClient_secret(client_secret);
        accesstoken.setCode(code);
        accesstoken.setGrant_type("authorization_code");
        accesstoken.setRedirect_uri(redirect_uri);
        System.out.println("dfs");
        String token = gitprovider.getAccessToken(accesstoken);
        Giteeuserinfo user = gitprovider.getUser(token);
        String username = user.getName();
        System.out.println("name" + username);
        model.addAttribute("name", username);
        return "greeting";
    }
}