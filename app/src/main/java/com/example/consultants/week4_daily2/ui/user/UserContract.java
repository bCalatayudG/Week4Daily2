package com.example.consultants.week4_daily2.ui.user;

import com.example.consultants.week4_daily2.ui.base.BasePresenter;
import com.example.consultants.week4_daily2.ui.base.BaseView;

public interface UserContract {

    interface View extends BaseView {
        void onSendingData(String name, Integer id, String company, String bio);
    }

    interface Presenter extends BasePresenter<View> {
        void getUserDataMain(String s);
    }

}