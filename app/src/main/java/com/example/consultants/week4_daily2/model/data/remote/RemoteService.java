package com.example.consultants.week4_daily2.model.data.remote;

import com.example.consultants.week4_daily2.model.person.PersonData;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RemoteService {

    //    using the call object
    @GET("users/{user_name}")
    Call<PersonData>  getUserData(@Path("user_name") String user_name, @Query("access_token") String access_token);
//    bCalatayudG

}
