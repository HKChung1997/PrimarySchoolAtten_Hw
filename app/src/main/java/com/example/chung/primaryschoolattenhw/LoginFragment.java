package com.example.chung.primaryschoolattenhw;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by Chung on 2/3/2017.
 */
public class LoginFragment extends Fragment{
    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_login, container, false);

        final EditText etUsername = (EditText) myView.findViewById(R.id.etUsername);
        final EditText etPassword = (EditText) myView.findViewById(R.id.etPassword);
        Button btnLogin = (Button) myView.findViewById(R.id.bLogin);
        Button btnForgot = (Button) myView.findViewById(R.id.bForget);

        btnForgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start new fragment and replace current fragment
                ForgetPwFragment nextFrag= new ForgetPwFragment();
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, nextFrag,"FRAGMENT_FORGOT")
                        .addToBackStack(null)
                        .commit();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success) {
                                newsFragment nextFrag= new newsFragment();
                                getFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, nextFrag,"FRAGMENT_NEWS")
                                        .addToBackStack(null)
                                        .commit();
                                navigationView.getMenu().setGroupVisible(R.id.group_2, true);
                                navigationView.getMenu().setGroupVisible(R.id.group_1, false);

                            }else{
                                Toast.makeText(getActivity(),"Login Failed",Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest(username, password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(loginRequest);
            }
        });
        return myView;

    }

}
