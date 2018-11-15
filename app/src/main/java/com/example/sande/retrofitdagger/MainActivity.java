package com.example.sande.retrofitdagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sande.retrofitdagger.di.ApiModule;
import com.example.sande.retrofitdagger.di.DaggerMyComponent;
import com.example.sande.retrofitdagger.di.MyComponent;
import com.example.sande.retrofitdagger.model.ForgotPasswordPOJO;
import com.example.sande.retrofitdagger.network.ApiService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Inject
    Retrofit retrofit;

    MyComponent component;
    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.btn_forgotPassword)
    Button btnForgotPassword;
    ApiService apiService;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

       /* component = DaggerMyComponent.builder()
                .apiModule(new ApiModule("http://rjtmobile.com"))
                .build();*/

        //component.injectRetrofit(this);
        ((MyApplication) getApplication()).getComponentInstance();
        apiService = retrofit.create(ApiService.class);


    }

    @OnClick(R.id.btn_forgotPassword)
    public void onViewClicked() {

        String email = etEmail.getText().toString();

        apiService.forgotPassword(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::responseResult, this::errorResult);

    }

    private void responseResult(ForgotPasswordPOJO forgotPasswordPOJO) {

        Log.i(TAG, "responseResult: " + forgotPasswordPOJO.toString());
    }

    private void errorResult(Throwable throwable) {
        Log.i(TAG, "errorResult: " + throwable.getMessage());
    }
}
