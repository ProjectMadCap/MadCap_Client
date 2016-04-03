package projectmadcap.madcap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;


import java.io.IOException;
import java.util.LinkedList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ActivityStudentHomePage extends AppCompatActivity {

    private static String guardianID;
    private static LinkedList<Student> students;
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
                            for (int i = 1; i < result[5].length() - 7; i++) {
                                guardianID += result[5].charAt(i);
                            }
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
                                            name.setText(students.get(0).getStudentName());
                                            stuGet.getBlank("http://45.55.142.81/api/behaviorHistory/" + students.get(0).getId(),
                                                    new Callback() {
                                                        @Override
                                                        public void onFailure(Call call, IOException e) {
                                                            Log.e("JSON FAILURE", "could not connect to database server");
                                                        }

                                                        @Override
                                                        public void onResponse(Call call, Response response) throws IOException {
                                                            String resp = response.body().string();
                                                            Log.d("HISTORY_WEEK", resp);
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

    public static LinkedList<Student> getStudents() {
        return students;
    }

    public static String getGuardianID() {
        return guardianID;
    }
}