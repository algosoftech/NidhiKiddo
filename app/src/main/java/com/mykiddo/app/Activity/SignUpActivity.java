package com.mykiddo.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.JsonObject;
import com.mykiddo.app.ModelClass.Signup_first_vmodel;
import com.mykiddo.app.Networkstate;
import com.mykiddo.app.R;
import com.mykiddo.app.Service.ApiClient;
import com.mykiddo.app.Service.ApiInterface;
import com.mykiddo.app.Service.KeyGenerationClass;
import com.mykiddo.app.Service.Result_SignUpOne;
import com.mykiddo.app.Service.Result_UniqueMobile;
import com.mykiddo.app.Service.Result_category;
import com.mykiddo.app.Service.Submit_result;
import com.mykiddo.app.Utils.LocationTracker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tv_text,step1_login;
    ImageView tv_calender;
    Button button_next;
    private int mYear, mMonth, mDay, mHour, mMinute;
    LinearLayout dobLayout;
    TextView tv_dob,Text_title;
    LinearLayout linearLayout,linear_name, linear_last;
    RadioGroup radio_group;
    RadioButton radioButton,button2, button3;
    EditText editText,edit_last,edit_first;
    ImageView imageView,spinner_image;
    LinearLayout Form_container;
    View childView,RadiochildView,button_view,SpinnerView;
    ArrayList<View> views;
    Spinner spinner;
    ArrayList<String> spinnerList;
    boolean bothVisible=false;
    ArrayList<Result_category.CategoryDatum> category_arr ;
    HashMap<Integer, EditText>editviewMap= new HashMap<>();
    HashMap<Integer, Spinner>spinnerviewMap= new HashMap<>();
    HashMap<Integer, RadioGroup>radioviewMap= new HashMap<>();
    ArrayList<ViewGroup> viewlists= new ArrayList<>();
    JSONArray fieldsArr= null;
    int ViewarrSize=0,radio1=1,radio2 =2,radio3 =3;
    ScrollView scrollView;
    Call<JsonObject> call;
    String refreshedToken,latitude,longitude;
    LocationTracker locationTracker;
    HashMap<String, String> request_map = new HashMap<>();
    ArrayList<String>request_key = new ArrayList<>();
    ArrayList<Signup_first_vmodel> view_modellist = new ArrayList<>();
    Boolean isCatSelected= false,isGenderSelected = false;
    String selectedCatId;
    int radioButtonCount,rbSuffixId=1;
    String selectedRadio="";
    Boolean isformvalidate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        Form_container = findViewById(R.id.Scroll_Linear);
        scrollView = findViewById(R.id.Scroll_SignUp);
        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        locationTracker = new LocationTracker(this);


        latitude = Double.toString(locationTracker.getLatitude());
        longitude = Double.toString(locationTracker.getLongitude());
        Log.e("DeviceId",""+refreshedToken);
        if (Networkstate.isNetworkAvailable(this)){
            FirstSignUpPage();


        }else {
            Toast.makeText(SignUpActivity.this, R.string.network,Toast.LENGTH_LONG).show();
        }
//         views= new ArrayList<>();

        tv_text=(TextView)findViewById(R.id.tv_text);
//        for (int i=0;i<5;i++){
//            if (i==0){
//                bothVisible = true;
//                addEditFields(i);
//            }else if (i==1){
//                Radiogroup();
//            }else if (i==2){
//                bothVisible = false;
//               addEditFields(i);
//            }else if (i ==3){
//                addEditFields(i);
//            }else if (i ==4){
//                AddButton();
//            }
//
//        }


//        step1_login=(TextView)findViewById(R.id.step1_login);
//        btn_sign_up_next=(Button) findViewById(R.id.btn_sign_up_next);



//        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        tv_text.setLayoutParams(params);




//        btn_sign_up_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SignUpActivity.this, SignUpStep2Activity.class);
//                startActivity(i);
//            }
//        });
//
//        step1_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(SignUpActivity.this, MainActivity.class);
//                startActivity(i);
//            }
//        });


//        dobLayout=findViewById(R.id.ll_dob);


//      tv_dob=(TextView)findViewById(R.id.tv_dob);
//
//        dobLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                 Calendar c = Calendar.getInstance();
//                mYear = c.get(Calendar.YEAR);
//                mMonth = c.get(Calendar.MONTH);
//                mDay = c.get(Calendar.DAY_OF_MONTH);
//
//
//
//                DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpActivity.this,
//                        new DatePickerDialog.OnDateSetListener() {
//
//                            @Override
//                            public void onDateSet(DatePicker view, int year,
//                                                  int monthOfYear, int dayOfMonth) {
//
//                                tv_dob.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
//
//                            }
//                        }, mYear, mMonth, mDay);
//                datePickerDialog.show();
//                datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance().getTimeInMillis());
//            }
//
//        });
    }
    private void addEditFields(String field_id, String title, String name, String hint,String Maxvalue,String MinValue,String Require,int index){
        int max=0, min=0;
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            childView = inflater.inflate(R.layout.form_field, null); //question layout
            linearLayout = childView.findViewById(R.id.Edit_LinearName);
            imageView = childView.findViewById(R.id.Image_Name);
            editText = childView.findViewById(R.id.Edit_FirstName);
            linear_name = childView.findViewById(R.id.Edit_LinearName);
            if(!Maxvalue.isEmpty() && !MinValue.isEmpty()){
                 max= Integer.parseInt(Maxvalue);
                 min= Integer.parseInt(MinValue);
            }
            childView.setId(index);
            linearLayout.setId(index);
            imageView.setId(index);
            imageView.setImageResource(R.drawable.person);
            editText.setId(index);
            editText.setHint(hint);
            if(Require.equalsIgnoreCase("Y")){
                editText.setHint("*"+hint);
            }

            editText.setMaxLines(1);
            editText.setMaxEms(max);
            editText.setMinEms(min);
            Form_container.addView(childView);
        editviewMap.put(index,editText);
        new Signup_first_vmodel(name,"EditText",index);

          viewlists.add(Form_container);
//        Log.e("Details",""+views.get(0)+views.get(1));
    }
    private void Radiogroup(String field_id, String title, String name,String Require,int index,String rbutton1,String rbutton2, String rbutton3 ){

            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            RadiochildView = inflater.inflate(R.layout.radio_layout, null);
            radio_group = RadiochildView.findViewById(R.id.Radio_group);
            radioButton = RadiochildView.findViewById(R.id.Radio_button1);
            button2 = RadiochildView.findViewById(R.id.Radio_button2);
            Text_title = RadiochildView.findViewById(R.id.Text_title);
            button3 = RadiochildView.findViewById(R.id.Radio_button3);
            Text_title.setText(title);
            if (Require.equalsIgnoreCase("Y")){
                Text_title.setText("*"+title);
            }
            int rbId1= Integer.parseInt(String.valueOf(radio1)+"1");
            int rbId2= Integer.parseInt(String.valueOf(radio1)+"2");
            int rbId3= Integer.parseInt(String.valueOf(radio1)+"3");
            radioButton.setText(rbutton1);
            radioButton.setId(rbId1);
            button2.setText(rbutton2);
            button2.setId(rbId2);
            if(!rbutton3.isEmpty()) {
                button3.setId(rbId3);
                button3.setText(rbutton2);
            }


            Form_container.addView(RadiochildView);
           radioviewMap.put(index,radio_group);
        new Signup_first_vmodel(name,"RadioGroup",index);
        viewlists.add(Form_container);

        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int Selected_type = group.getCheckedRadioButtonId();
                if(Selected_type%01d ==1){
                    selectedRadio=String.valueOf(radioButton.getText().toString().toUpperCase().charAt(0));
                }else if(Selected_type%01d ==2){
                    selectedRadio=String.valueOf(button2.getText().toString().toUpperCase().charAt(0));
                }else if(Selected_type%01d==3){
                    selectedRadio = String.valueOf(button2.getText().toString().toUpperCase().charAt(0));
                }

            }
        });

    }

    private void AddButton(){
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        button_view = inflater.inflate(R.layout.button_layout, null);
        button_next = button_view.findViewById(R.id.Button_next);
        button_next.setText("Next");
        Form_container.addView(button_view);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateForm();
//                SubmitformOne();

            }
        });
    }

    private void validateForm() {

    for (int i =0;i< view_modellist.size();i++){
        String key =view_modellist.get(i).getType();

        if(view_modellist.get(i).getType().equalsIgnoreCase("EditText")){
                String str1= editviewMap.get(i).getText().toString();
                if (str1.isEmpty()){
                    Toast.makeText(SignUpActivity.this, key+" should not be empty! ", Toast.LENGTH_SHORT).show();

                }else {
                    request_map.put(key,str1);
                }

            }else if (view_modellist.get(i).getType().equalsIgnoreCase("Spinner")){
                Long str_spinner = spinnerviewMap.get(i).getSelectedItemId();
                if (!isCatSelected){
                    Toast.makeText(SignUpActivity.this, "Please select type ", Toast.LENGTH_SHORT).show();

                }else {
                    request_map.put(key,selectedCatId);
                }

            }else if (view_modellist.get(i).getType().equalsIgnoreCase("RadioGroup")){
                String radio_group = String.valueOf(radioviewMap.get(i).getCheckedRadioButtonId());
                if (selectedRadio.isEmpty()){

                    Toast.makeText(SignUpActivity.this, "Please select gender ", Toast.LENGTH_SHORT).show();

                }else {
                    request_map.put(key,selectedRadio);
                }

            }
            }
    for (int j=0;j<request_key.size();j++){
     if (request_map.get(request_key.get(j)).isEmpty()){

         Toast.makeText(SignUpActivity.this, "Please fill details ", Toast.LENGTH_SHORT).show();
         isformvalidate = false;
         break;

     }else {
         isformvalidate=true;
         SubmitformOne();
     }
    }
//    if (isformvalidate){
////            SubmitformOne();
//           }else {
//            Toast.makeText(SignUpActivity.this, "Please fill details ", Toast.LENGTH_SHORT).show();
//
//        }
    }

    private void addDropDown(int index){
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        SpinnerView = inflater.inflate(R.layout.spinner_layout, null);
        spinner_image = SpinnerView.findViewById(R.id.Image_view);
        spinner = SpinnerView.findViewById(R.id.Spinner);
        Form_container.addView(SpinnerView,index);
        spinner.setOnItemSelectedListener(SignUpActivity.this);
        spinnerviewMap.put(index,spinner);
        new Signup_first_vmodel("category_id","Spinner",index);
        viewlists.add(Form_container);
        ArrayAdapter<String>adpter = new ArrayAdapter<String>(SignUpActivity.this,android.R.layout.simple_spinner_item, spinnerList);
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adpter);

        Log.e("SpinnerList","inside_spinner"+spinnerList);
//                Spinner sp= (Spinner)viewMap.get(Form_container.getChildCount()-1);
//                sp.setAdapter(adpter);


    }




    private void FirstSignUpPage(){
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        call = apiInterface.SignUpOne(KeyGenerationClass.getEncryptedKey()
                ,KeyGenerationClass.getDate(),"imrd-admin","registrationform1");
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    Log.e("SignUpOne", "" + response.body().getAsJsonObject());
                    ArrayList<Result_SignUpOne.Result.FormField> formFieldList= new ArrayList<>();
                    JSONObject mainObj= new JSONObject(String.valueOf(response.body().getAsJsonObject()));
                    Log.e("mainObj",":"+mainObj);
                   int successInt = mainObj.getInt("success");
                   if(successInt ==1){
                      String msg= mainObj.getString("message");
                      JSONObject resultObj= new JSONObject(mainObj.getJSONObject("result").toString());
                      JSONObject signupDataObj= new JSONObject(resultObj.getJSONObject("signupFormOneData").toString());
                       String From_id = signupDataObj.getString("form_id");
                       String form_code = signupDataObj.getString("form_code");
                       String category_name = signupDataObj.getString("category_name");
                       fieldsArr = signupDataObj.getJSONArray("form_fields");
                       String MinValue="",MaxValue="",Radio_button1="",Radio_button2 ="";
                       for (int i=0; i< fieldsArr.length();i++) {
                           ViewarrSize= fieldsArr.length();
                           JSONObject fieldObj = new JSONObject(fieldsArr.getJSONObject(i).toString());
                           String field_id = fieldObj.getString("field_id");
                           String Title = fieldObj.getString("title");
                           String Name = fieldObj.getString("name");
                           request_key.add(Name);
                           request_map.put(Name,"");
                           String Field_type = fieldObj.getString("type");
                           String Hint = fieldObj.getString("placeholder");
                           String require = fieldObj.getString("required");

                           JSONArray attrArray = null;
                           JSONArray fieldsArray = null;
                           try{
                               attrArray= fieldObj.getJSONArray("attribute_data");
                               if (attrArray.length() > 0) {
                                   for (int j=0;j<attrArray.length();j++){
                                       JSONObject strlengthobj = new JSONObject(attrArray.get(j).toString());
                                       if (j==0){
                                            MinValue = strlengthobj.getString("value");
                                       }else {
                                            MaxValue = strlengthobj.getString("value");
                                       }

                                   }

                                   Log.e("List","index"+i);
                                   Toast.makeText(SignUpActivity.this, "List found:" + fieldsArr.length(), Toast.LENGTH_SHORT).show();
                               }
                           } catch (JSONException ex) {
                               ex.printStackTrace();
                           } finally {
//                               if (innerArray.get(i) == null) {
                                   String strfieldlist = fieldObj.getString("attribute_data");
                                   if (!strfieldlist.isEmpty()) {
                                       Log.e("ListString","string"+i);

                                       Toast.makeText(SignUpActivity.this, "list as string:" + strfieldlist, Toast.LENGTH_SHORT).show();
                                   }
//                               }
                           }
                           try {
                               fieldsArray = fieldObj.getJSONArray("fields_data");
                               radioButtonCount= fieldsArray.length();
                               if (fieldsArray.length()>0){
                                   for (int k =0;k<fieldsArray.length();k++){
                                       JSONObject genFieldObj = new JSONObject(fieldsArray.get(k).toString());
                                       if (k==0){
                                           Radio_button1 = genFieldObj.getString("name");
                                       }else {
                                           Radio_button2 = genFieldObj.getString("name");

                                       }
                                   }
                               }

                           }catch (JSONException ex){
                               ex.printStackTrace();
                           }finally {
                               String strfieldlist = fieldObj.getString("fields_data");
                               if (!strfieldlist.isEmpty()) {
                                   Log.e("ListString","string"+i);

                                   Toast.makeText(SignUpActivity.this, "list as string:" + strfieldlist, Toast.LENGTH_SHORT).show();
                               }



                           }

                           if (Field_type.equalsIgnoreCase("text")){
                                   addEditFields( field_id,Title,Name,Hint,MaxValue,MinValue,require,i);

                           }else if (Field_type.equalsIgnoreCase("radio")){
                               Radiogroup(field_id,Title,Name,require,i,Radio_button1,Radio_button2,"");


                           }else if(Field_type.equalsIgnoreCase("date")){
                               addEditFields( field_id,Title,Name,Hint,MaxValue,MinValue,require,i);

                           }
                       }
                       Dropdown();
//                       Dropdown();
                       AddButton();
                       Toast.makeText(SignUpActivity.this, msg, Toast.LENGTH_SHORT).show();
                   }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }
        });

    }

    private void Dropdown(){

        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<Result_category>calldd = apiInterface.Category(KeyGenerationClass.getEncryptedKey()
                ,KeyGenerationClass.getDate(),"imrd-admin");
        calldd.enqueue(new Callback<Result_category>() {
            @Override
            public void onResponse(Call<Result_category> call, Response<Result_category> response) {
                Log.e("Dropdown",":"+response.body().getMessage()+"\n raw:"+call.isExecuted());
                category_arr = new ArrayList<>();
                category_arr = response.body().getResult().getCategoryData();
                spinnerList= new ArrayList<>();
                for (int i=0;i<category_arr.size();i++){
                     String Category_name = category_arr.get(i).getCategoryName();

                    spinnerList.add(Category_name);


                }
                if (ViewarrSize >0 ){
                    addDropDown(ViewarrSize);
                    ViewarrSize =0;
                }else{
                    ViewarrSize= viewlists.size();
                    ViewarrSize = scrollView.getChildCount()-1;
                    addDropDown(ViewarrSize);
                    ViewarrSize =0;
                }





            }

            @Override
            public void onFailure(Call<Result_category> call, Throwable t) {
              Log.e("DropdownException","ex"+t);
            }

        });

    }


    private void SubmitformOne(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        request_map.put("category_id","100000000000001");
        request_map.put("form_code","registrationform1");
        request_map.put("device_type","Android");
        request_map.put("device_id",refreshedToken);
        request_map.put("current_latitude",latitude);
        request_map.put("current_longitude",longitude);
        Call<Submit_result>submitform = apiInterface.SubmitSignUpOne(KeyGenerationClass.getEncryptedKey(),
                KeyGenerationClass.getDate(),"imrd-admin", request_map);
        submitform.enqueue(new Callback<Submit_result>() {
            @Override
            public void onResponse(Call<Submit_result> call, Response<Submit_result> response) {
                Log.e("SubmitData","formone"+response.body().getMessage());
                Intent intent = new Intent(SignUpActivity.this,SignUpStep2Activity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<Submit_result> call, Throwable t) {
                Log.e("SubmitData","formone"+t);

            }
        });

        }

        private void CheckMobileUnique(){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Result_UniqueMobile>uniqueNo = apiInterface.UniquePhoneNo(KeyGenerationClass.getEncryptedKey(),
                KeyGenerationClass.getDate(),"imrd-admin","");
        uniqueNo.enqueue(new Callback<Result_UniqueMobile>() {
            @Override
            public void onResponse(Call<Result_UniqueMobile> call, Response<Result_UniqueMobile> response) {

            }

            @Override
            public void onFailure(Call<Result_UniqueMobile> call, Throwable t) {

            }
        });

        }





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        isCatSelected=true;
        Long catIdlong= category_arr.get(position).getCategoryId();
        selectedCatId= String.valueOf(catIdlong);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        isCatSelected=false;

    }
}



