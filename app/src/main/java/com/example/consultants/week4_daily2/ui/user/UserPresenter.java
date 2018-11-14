package com.example.consultants.week4_daily2.ui.user;

import android.util.Log;

import com.example.consultants.week4_daily2.model.GithubRepository;
import com.example.consultants.week4_daily2.model.data.remote.RemoteDataSource;
import com.example.consultants.week4_daily2.model.person.PersonData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPresenter implements UserContract.Presenter {

    UserContract.View view;

    GithubRepository repository;
    private RemoteDataSource remoteDataSource;
    private static final String TAG = UserPresenter.class.getSimpleName() + "_TAG";

    public UserPresenter(GithubRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onAttach(UserContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    public void getUserDataMain(String s) {
        remoteDataSource = new RemoteDataSource();
        remoteDataSource.getUserData(s).enqueue(new Callback<PersonData>() {
            @Override
            public void onResponse(Call<PersonData> call, Response<PersonData> response) {
                Log.d(TAG, "onResponse: " + Thread.currentThread().getName());
                Log.d(TAG, "onResponse: "+ response.body().getLogin());
                String name = response.body().getLogin();
                Integer id = response.body().getId();
                String company = response.body().getCompany().toString();
                String bio = response.body().getBio().toString();
                Log.d(TAG, "onResponse: Company: "+company);
                view.onSendingData(name,id,company,bio);
            }

            @Override
            public void onFailure(Call<PersonData> call, Throwable t) {

            }
        });
        Log.d(TAG, "getUserData: ");
    }
}
