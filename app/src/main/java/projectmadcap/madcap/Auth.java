package projectmadcap.madcap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Auth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        EditText inputUsername = (EditText)findViewById(R.id.input_username);
        EditText inputPassword = (EditText)findViewById(R.id.input_password);
        Button loginButton = (Button)findViewById(R.id.btn_login);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {

    }

}
