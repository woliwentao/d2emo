package com.example.d2emo.provider;

import java.io.IOException;

import com.example.d2emo.dto.AccessTokendto;

import org.springframework.stereotype.Component;

import okhttp3.*;
// import okhttp3.OkHttpClient;
// import okhttp3.Request;
// import okhttp3.RequestBody;
// import okhttp3.Response;
import com.alibaba.fastjson.support.spring.FastjsonSockJsMessageCodec.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.FastJsonContainer.*;

@Component
public class GitProvider {
    public static String getAccessToken(AccessTokendto accesstokendto) {

        final MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstokendto));

        Request request = new Request.Builder().url("https://github.com/login/oauth/access_token").post(body).build();

        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            System.out.println(string);
            return string;
        } catch (IOException e) {
        }
        return null;
    }

}