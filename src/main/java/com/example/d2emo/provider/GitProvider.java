package com.example.d2emo.provider;

import java.io.IOException;

import com.example.d2emo.dto.AccessTokendto;
import com.example.d2emo.dto.Giteeuserinfo;

import org.springframework.stereotype.Component;

import okhttp3.*;
// import okhttp3.OkHttpClient;
// import okhttp3.Request;
// import okhttp3.RequestBody;
// import okhttp3.Response;
import com.alibaba.fastjson.support.spring.FastjsonSockJsMessageCodec.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.spring.FastJsonContainer.*;

@Component
public class GitProvider {
    public static String getAccessToken(AccessTokendto accesstokendto) {

        final MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstokendto));

        Request request = new Request.Builder().url("https://gitee.com/oauth/token").post(body).build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            // String[] split = string.split("&");
            JSONObject json = JSON.parseObject(string);
            String token = (String) json.get("access_token");
            // String token = split[0].split("=")[1];
            System.out.println(token);

            return token;
        } catch (IOException e) {
        }
        return null;
    }

    public Giteeuserinfo getUser(String accesstoken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://gitee.com/api/v5/user?access_token=" + accesstoken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            Giteeuserinfo user = JSON.parseObject(string, Giteeuserinfo.class);
            return user;
        } catch (IOException e) {
            // TODO: handle exception
            return null;
        }
    }

}