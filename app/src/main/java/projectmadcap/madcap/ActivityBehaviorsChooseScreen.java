package projectmadcap.madcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ActivityBehaviorsChooseScreen extends AppCompatActivity {

    AdapterWeek adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behaviors_choose_screen);

        Toolbar toolbar = (Toolbar)findViewById(R.id.fragment_toolbar);
        setSupportActionBar(toolbar);
        Button menu = (Button)findViewById(R.id.menu_button);

        RecyclerView week_list = (RecyclerView) findViewById(R.id.recycler_weeks);

        List<ModelWeek> weekArray = getWeeks();
        ActivityAuth.lastPageOpen = "ActivityBehaviorsChooseScreen";
        adapter = new AdapterWeek(ActivityBehaviorsChooseScreen.this, weekArray);
        week_list.setAdapter(adapter);
        week_list.setLayoutManager(new LinearLayoutManager(ActivityBehaviorsChooseScreen.this));
        if (menu != null) {
            menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ActivityBehaviorsChooseScreen.this, MenuActivity.class);
                    startActivity(intent);
                }
            });
        }
    }



    public List<ModelWeek> getWeeks(){
        List<ModelWeek> data = new ArrayList<>();

        ModelWeek week = new ModelWeek("Week 10", 5);
        data.add(0, week);
        week= new ModelWeek("Week 1", 7);
        data.add(1, week);
        week= new ModelWeek("Week 2", 4);
        data.add(2, week);
        week= new ModelWeek("Week 3", 2);
        data.add(3, week);
        week= new ModelWeek("Week 4", 6);
        data.add(4, week);
        week= new ModelWeek("Week 5", 10);
        data.add(5, week);
        week= new ModelWeek("Week 6", 10);
        data.add(6, week);
        week= new ModelWeek("Week 7", 7);
        data.add(7, week);
        week = new ModelWeek("Week 8", 8);
        data.add(8, week);
        week = new ModelWeek("Week 9", 4);
        data.add(9, week);


        return data;
    }
}
