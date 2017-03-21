package com.example.chung.primaryschoolattenhw;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Chung on 2/3/2017.
 */
public class ForgetPwFragment extends Fragment {
    View myView;

    Button bSend;
    EditText etEmail, etUsername;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.activity_forget, container, false);

        etUsername = (EditText) myView.findViewById(R.id.etUsername);
        etEmail = (EditText)myView.findViewById(R.id.etEmail);
        bSend = (Button) myView.findViewById(R.id.bSend);
        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Sent!", Toast.LENGTH_SHORT).show();
            }
        });
        return myView;

    }

}
