package example.org.test.w06d01sol.restcalls.model;

import android.util.Log;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;

import example.org.test.w06d01sol.restcalls.model.images.ImageResponse;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import static example.org.test.w06d01sol.restcalls.model.images.UrlConstants.ACTUAL_URL;

public class Okhttp3Helper {

    public static OkHttpClient okHttpClientWithInterceptor(){
        OkHttpClient okHttpClient;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
        return okHttpClient;
    }
    public static String getSyncroniousOkhttpResponse() throws IOException {
        OkHttpClient okHttpClient = okHttpClientWithInterceptor();
        Request request = new Request.Builder()
                .url(ACTUAL_URL)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }
    public static void getAsyncOkHttpResponse() {
        // OkHttpClient okHttpClient = new OkHttpClient();
        OkHttpClient okHttpClient = okHttpClientWithInterceptor();
        Request request = new Request.Builder()
                .url(ACTUAL_URL)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("TAG", "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String jsonResponse = response.body().string();
                Gson gsonConverter = new Gson();
                Log.d("TAG_OKHTTP_ASYNC", jsonResponse);
                EventBus.getDefault().post(gsonConverter.fromJson(jsonResponse, ImageResponse.class));

            }
        });
    }
}
