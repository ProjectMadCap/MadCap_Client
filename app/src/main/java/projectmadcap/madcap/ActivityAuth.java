package projectmadcap.madcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ActivityAuth extends AppCompatActivity {

    public static String token;
    EditText inputEmail;
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        inputEmail = (EditText)findViewById(R.id.input_email);
        inputPassword = (EditText)findViewById(R.id.input_password);
        Button loginButton = (Button)findViewById(R.id.btn_login);

        if (loginButton != null) {
            loginButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    try {
                        login();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void login() throws IOException {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        Log.d("EMAIL_PASSWORD", email + " " + password);
        LoginPost loginPost = new LoginPost();
        Pair<String, String> emailPair = new Pair<>("email", email);
        Pair<String, String> passPair = new Pair<>("password", password);

        Call call = loginPost.post("http://45.55.142.81/authenticate", emailPair, passPair, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("JSON FAILURE", "could not connect to database server");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String[] result = response.body().string().split(":");
                token = "";
                for(int i = 1; i < result[3].length()-2; i++)
                    token += result[3].charAt(i);
                Log.d("RESPONSE", token);
                Intent intent = new Intent(ActivityAuth.this, ActivityStudentHomePage.class);
                startActivity(intent);
            }
        });
    }
}
