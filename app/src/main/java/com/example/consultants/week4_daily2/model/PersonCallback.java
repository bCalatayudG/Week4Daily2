package com.example.consultants.week4_daily2.model;

import com.example.consultants.week4_daily2.model.person.PersonData;

import java.util.List;

public interface PersonCallback {
    void onSuccess(List<PersonData> userList);

    void onFailure(String error);
}
