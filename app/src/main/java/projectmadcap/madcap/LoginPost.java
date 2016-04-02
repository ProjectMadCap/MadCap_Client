package projectmadcap.madcap;

import android.util.Log;
import android.util.Pair;

import java.io.IOException;

import com.squareup.mimecraft.FormEncoding;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
//import okhttp3.Response;

public class LoginPost {
    public static final MediaType JSON =
            MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    Call post(String url, Pair<String, String> email, Pair<String, String> password, Callback callback) throws IOException {
//        Log.d("JSONSTR", json);
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

    /*String loginJson(String email, String password) {
        return "'{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}'";
    }*/
}
