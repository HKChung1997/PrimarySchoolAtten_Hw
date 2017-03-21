package com.example.chung.primaryschoolattenhw;

import com.android.volley.Request;
import com.google.api.client.googleapis.auth.clientlogin.ClientLogin;
import  com.android.volley.Response;
import  com.android.volley.toolbox.StringRequest;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by Chung on 21/3/2017.
 */

public class LoginRequest extends StringRequest{
    private static  final String LOGIN_REQUEST_URL = "";
    private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener) {
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    public Map<String, String> getParams() {
        return params;
    }
}
