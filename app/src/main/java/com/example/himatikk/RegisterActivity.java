package com.example.himatikk;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText namaRegis, nimregis, kelasregis, mViewUser, mViewPassword;
    private Button btnregis;
    private TextView ViewSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        namaRegis =findViewById(R.id.et_namaregis);
        nimregis =findViewById(R.id.et_nim);
        kelasregis =findViewById(R.id.et_kelas);
        mViewUser =findViewById(R.id.et_usernameregis);
        mViewPassword =findViewById(R.id.et_passregis);
        ViewSignIn = findViewById(R.id.tv_signin);

        findViewById(R.id.btnsignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { razia();
            }
        });

        ViewSignIn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),
                        LoginActivity.class));

            }
        });
    }


    private void razia(){
        namaRegis.setError(null); nimregis.setError(null); kelasregis.setError(null); mViewUser.setError(null); mViewPassword.setError(null);
        View fokus = null; boolean cancel = false;


        String namauserr = namaRegis.getText().toString(); String nimregiss = nimregis.getText().toString(); String kelasregiss = kelasregis.getText().toString(); String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();


        if (TextUtils.isEmpty(user)){ mViewUser.setError("This field is required"); fokus = mViewUser;

            cancel = true;
        }else if(cekUser(user)){
            mViewUser.setError("This Username is already exist"); fokus = mViewUser;
            cancel = true;
        }


        if (TextUtils.isEmpty(password)){ mViewPassword.setError("This field is required"); fokus = mViewPassword;
            cancel = true;

        }


        if (cancel){
            fokus.requestFocus();
        }else{
            Preferences.setRegisteredUser(getBaseContext(),user); Preferences.setRegisteredPass(getBaseContext(),password); finish();
        }
    }



    private boolean cekUser(String user){
        return
                user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}


