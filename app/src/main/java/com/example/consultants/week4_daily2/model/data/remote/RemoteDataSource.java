package com.example.consultants.week4_daily2.model.data.remote;

import com.example.consultants.week4_daily2.Constants;
import com.example.consultants.week4_daily2.model.person.PersonData;
import com.example.consultants.week4_daily2.utility.NetworkHelper;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private Retrofit createInstance(){
        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_RANDOM_URL)
//                use for converting the response using Gson
                .addConverterFactory(GsonConverterFactory.create())
                //using rxjava adapter
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private  RemoteService getRemoteService() {
        return createInstance().create(RemoteService.class);
    }

    //use call object
    public Call<PersonData> getUserData(String etMain) {
        return getRemoteService().getUserData(etMain,Constants.access_token);
    }
}
