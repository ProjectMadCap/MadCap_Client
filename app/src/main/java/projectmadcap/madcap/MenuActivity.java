package projectmadcap.madcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import projectmadcap.madcap.socketIO.SocketActivity;

public class MenuActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button homeButton = (Button)findViewById(R.id.home_button);
        Button chatButton = (Button)findViewById(R.id.chat_button);
        Button behaviorsButton = (Button)findViewById(R.id.behaviors_button);


        if (homeButton != null) {
            homeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ActivityAuth.lastPageOpen.equals("ActivityStudentHomePage"))
                        finish();
                    else {
                        Intent intent = new Intent(MenuActivity.this, ActivityStudentHomePage.class);
                        startActivity(intent);
                    }
                }
            });
        }

        if (chatButton != null) {
            chatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ActivityAuth.lastPageOpen.equals("SocketActivity"))
                        finish();
                    else {
                        Intent intent = new Intent(MenuActivity.this, SocketActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }

        if (behaviorsButton != null) {
            behaviorsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ActivityAuth.lastPageOpen.equals("ActivityBehaviorsChooseScreen"))
                        finish();
                    else {
                        Intent intent = new Intent(MenuActivity.this, ActivityBehaviorsChooseScreen.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
