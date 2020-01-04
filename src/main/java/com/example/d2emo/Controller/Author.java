package com.example.d2emo.Controller;

import com.example.d2emo.dto.AccessTokendto;
import com.example.d2emo.provider.GitProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Author {

    @Autowired
    private GitProvider gitprovider;

    @GetMapping("/callback")
    public String callback(@RequestParam(value = "code", required = true, defaultValue = "no") String code,
            @RequestParam(value = "state", required = true, defaultValue = "0") String state, Model model) {

        AccessTokendto accesstoken = new AccessTokendto();
        accesstoken.setClient_id("c67360d0d52d9780ec95a67a18187a253165a49a1290ca46eb792b6dfeb93a69");
        accesstoken.setClient_secret("2fb767ed6fd9048747d4737695659dd435ac557976085eb2b02bdb603d35b2dc");
        accesstoken.setCode(code);
        accesstoken.setState(state);
        accesstoken.setRedirect_uri("http://localhost:8080/callback");
        gitprovider.getAccessToken(accesstoken);
        return "index";
    }
}