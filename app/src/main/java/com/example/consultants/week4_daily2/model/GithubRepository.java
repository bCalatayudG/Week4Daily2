package com.example.consultants.week4_daily2.model;

import com.example.consultants.week4_daily2.CacheManager;
import com.example.consultants.week4_daily2.model.data.local.LocalDataSource;
import com.example.consultants.week4_daily2.model.data.remote.RemoteDataSource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class GithubRepository {

    LocalDataSource localDataSource;
    RemoteDataSource remoteDataSource;

    public GithubRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }


    public void getRandomUsers(String gender, int results, final PersonCallback callback) {
/*
//        if cache is dirty make the network call
        if (CacheManager.isCacheDirty()) {
            remoteDataSource.getRandomUserObs(gender, results)
//                    make the network call on the worker thread
                    .subscribeOn(Schedulers.io())
//                    get the results back on the main thread
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new RemoteObserver(callback));
        }

*/
    }
}