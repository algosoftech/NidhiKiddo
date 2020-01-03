package com.mykiddo.app.Service;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("user/getSignupFormOne")
    Call<JsonObject> SignUpOne(@Header("Apikey") String Key, @Header("Apidate")String date,
                               @Header("Apidatabase")String db, @Field("form_code") String From);


    @GET("common/getUserCategory")
    Call<Result_category>Category(@Header("Apikey") String Key, @Header("Apidate")String date,
                                  @Header("Apidatabase")String db);
    @FormUrlEncoded
    @POST("user/checkMobileUnique")
    Call<Result_UniqueMobile>UniquePhoneNo(@Header("Apikey") String Key, @Header("Apidate")String date,
                                           @Header("Apidatabase")String db, @Field("user_phone") String PhoneNo);

    @FormUrlEncoded
    @POST("user/putSignupFormOneData")
    Call<Submit_result>SubmitSignUpOne(@Header("Apikey") String Key, @Header("Apidate")String date,
                                       @Header("Apidatabase")String db,@FieldMap HashMap<String, String> map);

    @FormUrlEncoded
    @POST("user/getSignupFormTwo")
    Call<Result_SignUpTwo>SignUpTwo(@Header("Apikey") String Key, @Header("Apidate")String date,
                                    @Header("Apidatabase")String db, @Field("form_code") String From);

    @FormUrlEncoded
    @POST("user/checkEmailUnique")
    Call<Result_UniqueMobile>UniqueEmail(@Header("Apikey") String Key, @Header("Apidate")String date,
                                         @Header("Apidatabase")String db, @Field("user_email") String PhoneNo);


    




}
