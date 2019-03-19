package example.org.test.w06d01sol.restcalls.model;

import example.org.test.w06d01sol.restcalls.model.images.ImageResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static example.org.test.w06d01sol.restcalls.model.images.UrlConstants.BASE_URL;
import static example.org.test.w06d01sol.restcalls.model.images.UrlConstants.PATH;
import static example.org.test.w06d01sol.restcalls.model.images.UrlConstants.QUERY_RESULTS;

public class RetrofitHelper {

    private Retrofit getRetrofitClient(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(Okhttp3Helper.okHttpClientWithInterceptor())
                .build();
    }
    private GetRandomImages getImageResponse(){
        return getRetrofitClient().create(GetRandomImages.class);
    }

    public Call<ImageResponse> getRandomUsers(String numOfResponses) {
        return getImageResponse().getRandomImages("3");
    }

    public interface GetRandomImages{
        @GET(PATH)
        Call<ImageResponse> getRandomImages(@Query(QUERY_RESULTS) String numOfResponse);
    }
}
