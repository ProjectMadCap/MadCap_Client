package projectmadcap.madcap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityBehaviorsChooseScreen extends AppCompatActivity implements View.OnClickListener, AdapterWeek.ClickListener{
    List<ModelWeek> data;
    AdapterWeek adapter;
    public static Behavior selectedBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_behaviors_choose_screen);

        RecyclerView week_list = (RecyclerView) findViewById(R.id.recycler_weeks);

        List<ModelWeek> weekArray = getWeeks();
        TextView name = (TextView)findViewById(R.id.student_name);
        name.setText(ActivityAuth.studentName);

        adapter = new AdapterWeek(ActivityBehaviorsChooseScreen.this, weekArray);
        week_list.setAdapter(adapter);
        week_list.setLayoutManager(new LinearLayoutManager(ActivityBehaviorsChooseScreen.this));
        adapter.setClickListener(this);
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

    @Override
    public void onClick(View v) {

    }

    @Override
    public void matchClicked(View view, int position) {
        //ModelWeek week = data.get(position);
        //String weekS = week.getWeek();
        Intent intent = new Intent(this, ActivityBehaviorsMainScreen.class);
        // intent.putExtra("matchId", weekS);
        startActivity(intent);
    }
    public static void addSelectedWeek(Behavior weekToAdd) {
        ActivityBehaviorsChooseScreen.selectedBehavior = weekToAdd;
    }
}
