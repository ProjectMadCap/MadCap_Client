package projectmadcap.madcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityBehaviorsMainScreen extends AppCompatActivity {

    public static Behavior behaviorToAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behaviors_main_screen);
        //Toolbar toolbar = (Toolbar)findViewById(R.id.fragment_toolbar);
        //setSupportActionBar(toolbar);
        Button menu = (Button)findViewById(R.id.menu_button);
        TextView weekView = (TextView)findViewById(R.id.week_text_view);
        weekView.setText(behaviorToAdd.getWeek());
        TextView name = (TextView)findViewById(R.id.student_name);
        name.setText(ActivityAuth.studentName);

        ImageView image = (ImageView)findViewById(R.id.overall_progress_image_view);
        switch(behaviorToAdd.getPerformance())
        {
            case 0:
            case 1:
                image.setImageResource(R.drawable.smile0);
                break;
            case 2:
            case 3:
                image.setImageResource(R.drawable.smile2);
                break;
            case 4:
            case 5:
                image.setImageResource(R.drawable.smile4);
                break;
            case 6:
            case 7:
                image.setImageResource(R.drawable.smile6);
                break;
            case 8:
            case 9:
                image.setImageResource(R.drawable.smile8);
                break;
            default:
                image.setImageResource(R.drawable.smile10);
        }

        TextView comments = (TextView)findViewById(R.id.comments_to_add);
        comments.setText(behaviorToAdd.getNotes());

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
