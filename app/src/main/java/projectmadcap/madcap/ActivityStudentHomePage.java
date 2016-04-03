package projectmadcap.madcap;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;


import java.io.IOException;
import java.util.LinkedList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/*
    code I added


ActivityStudentHomePage

package projectmadcap.madcap;
 import android.content.Context;
 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;
 import android.support.v7.widget.RecyclerView;
 import android.text.Layout;
 import android.util.AttributeSet;
 import android.util.Log;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.AdapterView;
 import android.widget.ArrayAdapter;
 import android.widget.Button;
 import android.widget.ListView;
 import android.widget.TextView;
  import org.json.JSONArray;
 import org.json.JSONException;
  
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.LinkedList;
 import java.util.zip.Inflater;
  import okhttp3.Call;
 import okhttp3.Callback;
 import okhttp3.Response;
  public class ActivityStudentHomePage extends AppCompatActivity {
       private static String guardianID;
     private static LinkedList<Student> students;
     TextView name;
     private RecyclerView week_list;
     private Behavior[] behaviors;
     private BehaviorList behaviorList;
     private BehaviorNotifications[] behaviorNotificationsList;
      @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_student_home_page);
         //final StudentGet stuGet = new StudentGet();
         students = new LinkedList<Student>();
         students.add(new Student("John Baggs", "4"));
          name = (TextView)findViewById(R.id.student_name);
          name.setText(students.get(0).getStudentName());
        // week_list = (RecyclerView) name.findViewById(R.id.recycler_weeks);
         behaviors = new Behavior[4];
         behaviors[0] = new Behavior("week 1", 5, "Was shy and lashed out", false);
         behaviors[1] = new Behavior("week 3", 9, "Excellent except for one argument", false);
         behaviors[2] = new Behavior("week 2", 10, "Perfect", true);
         behaviors[3] = new Behavior("week 4", 2, "Was picking fights", false);
         behaviorList = new BehaviorList();
         for(int count = 0; count < 4; count++)
             behaviorList.addBehavior(behaviors[count]);
         int counter = 0;
         for(int count = 0; count < behaviorList.size(); count++)
             if(behaviorList.get(count).isPastViewed() == false)
                 counter++;
         behaviorNotificationsList = new BehaviorNotifications[counter];
         counter = 0;
         for(int count = 0; count < behaviorList.size(); count++)
         {
             if(behaviorList.get(count).isPastViewed() == false) {
                 behaviorNotificationsList[counter] = new
BehaviorNotifications(behaviorList.get(count).week);
                 counter++;
             }
         }
         AdapterNotification adapterNotification = new AdapterNotification(this, R.layout.fragment_notification_behavior_template, behaviorNotificationsList);
         ListView listView = (ListView)findViewById(R.id.student_home_page_list_view); 
        listView.setAdapter(adapterNotification);
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
 {
             @Override
             public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 //behaviorNotificationsList[position]
             }
         });




 */

public class ActivityStudentHomePage extends AppCompatActivity {

    //private RecyclerView week_list;
    private static String guardianID;
    private static LinkedList<Student> students;
    private static BehaviorList behaviors;
    private BehaviorNotifications[] behaviorNotificationsList;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_home_page);
        final StudentGet stuGet = new StudentGet();
        name = (TextView)findViewById(R.id.student_name);

        try {
            Call call = stuGet.getBlank("http://45.55.142.81/api/sexyGuardian/" +  ActivityAuth.getEmail(),
                    new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            Log.e("JSON FAILURE", "could not connect to database server");
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String resp = response.body().string();
                            Log.d("GUARD_RESPONSE", resp);
                            String[] result = resp.split(":");
                            guardianID = "";
                            if(result.length > 1)
                                for (int i = 1; i < result[5].length() - 7; i++) {
                                    guardianID += result[5].charAt(i);
                                }
                            else
                                return;
                            Log.d("GUARDIAN_ID", guardianID);
                            stuGet.getStudent("http://45.55.142.81/api/student/" + guardianID,
                                    ActivityStudentHomePage.getGuardianID(), new Callback() {
                                        @Override
                                        public void onFailure(Call call, IOException e) {
                                            Log.e("JSON FAILURE", "could not connect to database server");
                                        }

                                        @Override
                                        public void onResponse(Call call, Response response) throws IOException {
                                            String resp = response.body().string();
                                            //resp = resp.replace("[", "");
                                            //resp = resp.replace("]", "");
                                            Log.d("STUNAME_RESPONSE", resp);
                                            JSONArray job = null;
                                            try {
                                                job = new JSONArray(resp);
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                            int numStudents = job.length();
                                            students = new LinkedList<Student>();
                                            for (int i = 0; i < numStudents; i++) {
                                                try {
                                                    students.add(new Student(job.getJSONObject(i).getString("first") + " "
                                                            + job.getJSONObject(i).getString("last"),
                                                            job.getJSONObject(i).getString("_id")));
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            final String nameStr = students.get(0).getStudentName();
                                            stuGet.getBlank("http://45.55.142.81/api/behaviorHistory/" + students.get(0).getId(),
                                                    new Callback() {
                                                        @Override
                                                        public void onFailure(Call call, IOException e) {
                                                            Log.e("JSON FAILURE", "could not connect to database server");
                                                        }

                                                        @Override
                                                        public void onResponse(Call call, Response response) throws IOException {
                                                            final String weekStr = response.body().string();
                                                            Log.d("HISTORY_WEEK", weekStr);
                                                            runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    name.setText(nameStr);
                                                                    JSONArray weeks = null;
                                                                    behaviors = new BehaviorList();
                                                                    try {
                                                                        weeks = new JSONArray(weekStr);
                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    for(int i = 0; i < weeks.length(); i++) {
                                                                        try {
                                                                            behaviors.addBehavior(new Behavior( weeks.getJSONObject(i).getString("week"),
                                                                                    weeks.getJSONObject(i).getString("rating"),
                                                                                    weeks.getJSONObject(i).getString("description"), false));
                                                                        } catch (JSONException e) {
                                                                            e.printStackTrace();
                                                                        }
                                                                    }
                                                                    int counter = 0;
                                                                    for(int count = 0; count < behaviors.size(); count++) {
                                                                        if (behaviors.get(count).isPastViewed() == false) {
                                                                            counter++;
                                                                        }
                                                                    }        behaviorNotificationsList = new BehaviorNotifications[counter];
                                                                    counter = 0;
                                                                    for(int count = 0; count < behaviors.size(); count++) {
                                                                        if(behaviors.get(count).isPastViewed() == false) {
                                                                            behaviorNotificationsList[counter] = new
                                                                                    BehaviorNotifications(behaviors.get(count).weekNumber);
                                                                            counter++;
                                                                        }
                                                                    }
                                                                    AdapterNotification adapterNotification = new AdapterNotification(ActivityStudentHomePage.this, R.layout.fragment_notification_behavior_template, behaviorNotificationsList);
                                                                    ListView listView = (ListView)findViewById(R.id.student_home_page_list_view);
                                                                    listView.setAdapter(adapterNotification);
                                                                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                                                    {

                                                                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                                            //behaviorNotificationsList[position]
                                                                        }
                                                                    });
                                                                }
                                                            });
                                                        }


                                                    });
                                        }
                                    });
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static BehaviorList getBehaviors() {
        return behaviors;
    }


    public BehaviorNotifications[] getBehaviorNotificationsList() {
        return behaviorNotificationsList;
    }

    public static LinkedList<Student> getStudents() {
        return students;
    }

    public static String getGuardianID() {
        return guardianID;
    }
}
