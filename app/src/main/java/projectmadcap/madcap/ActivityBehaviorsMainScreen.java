package projectmadcap.madcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ActivityBehaviorsMainScreen extends AppCompatActivity {

    public static Behavior behaviorToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behaviors_main_screen);
        Toolbar toolbar = (Toolbar)findViewById(R.id.fragment_toolbar);
        setSupportActionBar(toolbar);
        Button menu = (Button)findViewById(R.id.menu_button);

        ActivityAuth.lastPageOpen = "ActivityBehaviorsMainScreen";
        if (menu != null) {
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ActivityBehaviorsMainScreen.this, MenuActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


}
