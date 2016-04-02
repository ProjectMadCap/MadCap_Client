package projectmadcap.madcap;

import android.util.Pair;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LoginPost {
    OkHttpClient client = new OkHttpClient();

    Call post(String url, Pair<String, String> email, Pair<String, String> password, Callback callback) throws IOException {
        RequestBody body = new FormBody.Builder()
                .add(email.first, email.second)
                .add(password.first, password.second)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
        return call;
    }
}
