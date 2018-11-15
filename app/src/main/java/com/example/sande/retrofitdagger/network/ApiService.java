package com.example.sande.retrofitdagger.network;

import com.example.sande.retrofitdagger.model.ForgotPasswordPOJO;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    //http://rjtmobile.com/aamir/pms/android-app/pms_forgot_pass.php?email=aa@aa.com
    @GET("/aamir/pms/android-app/pms_forgot_pass.php?")
    Observable<ForgotPasswordPOJO> forgotPassword(@Query("email") String email);

}
