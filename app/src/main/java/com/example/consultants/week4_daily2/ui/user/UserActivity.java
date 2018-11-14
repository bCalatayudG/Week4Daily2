package com.example.consultants.week4_daily2.ui.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.consultants.week4_daily2.R;
import com.example.consultants.week4_daily2.model.GithubRepository;
import com.example.consultants.week4_daily2.model.data.local.LocalDataSource;
import com.example.consultants.week4_daily2.model.data.remote.RemoteDataSource;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    private UserPresenter presenter;
    private RemoteDataSource remoteDataSource;
    private static final String TAG = UserActivity.class.getSimpleName() + "_TAG";
    TextView tvName;
    TextView tvId;
    TextView tvCompany;
    TextView tvBio;
    EditText etMain;

    TextView tvNameLabel;
    TextView tvBioLabel;
    TextView tvIdLabel;
    TextView tvCompanyLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new UserPresenter(new GithubRepository(new LocalDataSource(), new RemoteDataSource()));
        remoteDataSource = new RemoteDataSource();
        tvName = findViewById(R.id.tvName);
        tvId = findViewById(R.id.tvId);
        tvCompany = findViewById(R.id.tvCompany);
        tvBio = findViewById(R.id.tvBio);
        etMain = findViewById(R.id.etMain);

        tvBioLabel = findViewById(R.id.tvBioLabel);
        tvIdLabel = findViewById(R.id.tvIdLabel);
        tvCompanyLabel = findViewById(R.id.tvCompanyLabel);
        tvNameLabel = findViewById(R.id.tvNameLabel);

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onDetach();
    }

    public void onTest(View view) {
        String s = etMain.getText().toString();
        if (!etMain.getText().toString().equals(""))
            presenter.getUserDataMain(etMain.getText().toString());

//        remoteDataSource.getUserData().enqueue(new Callback<PersonData>() {
//            @Override
//            public void onResponse(Call<PersonData> call, Response<PersonData> response) {
//                Log.d(TAG, "onResponse: " + Thread.currentThread().getName());
//                Log.d(TAG, "onResponse: "+ response.body().getLogin());
//            }
//
//            @Override
//            public void onFailure(Call<PersonData> call, Throwable t) {
//
//            }
//        });
    }

    @Override
    public void showError(String error) {
        Log.d(TAG, "showError: " + error);
    }

    @Override
    public void onSendingData(String name, Integer id, String company, String bio) {
        tvName.setText(name);
        tvId.setText(String.valueOf(id));
        tvCompany.setText(company);
        tvBio.setText(bio);

        tvBioLabel.setVisibility(View.VISIBLE);
        tvNameLabel.setVisibility(View.VISIBLE);
        tvCompanyLabel.setVisibility(View.VISIBLE);
        tvIdLabel.setVisibility(View.VISIBLE);
    }
}
