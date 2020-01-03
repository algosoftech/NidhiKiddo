package com.mykiddo.app.Activity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mykiddo.app.R;
import com.mykiddo.app.RoutListData;
import com.mykiddo.app.Adapter.RouteListAdapter;

import java.util.ArrayList;
import java.util.Calendar;

public class RouteListActivity extends AppCompatActivity implements RouteListAdapter.ImaggListner {

    RecyclerView mRecyclerView;

    FloatingActionButton add_float;

    ImageView start_time;

    LinearLayout timepickerleft,timepickerright;

    TextView tv_start_time,drop_time_tv,startpoint,destination;
    private int mHour, mMinute,mSecond,mHour2, mMinute2,mSecond2;

    private ArrayList<RoutListData> mModelList;

    Button button1,submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routelist);

        add_float = findViewById(R.id.add_float);


        mRecyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RouteListActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mModelList = new ArrayList<>();
        mModelList.add(new RoutListData("Route1", "Sector 62", "Sector 62"));
        mModelList.add(new RoutListData("Route2", "Jama Mazid", "Mayur Vihar"));
        mModelList.add(new RoutListData("Route3", "Jahagir Puri", "Narayan Cir..."));
        mModelList.add(new RoutListData("Route4", "Mori Gate T..", "IGI"));
        mModelList.add(new RoutListData("Route5", "Jss College", "JSS College"));
        mModelList.add(new RoutListData("Route6", "Iskon Temple", "Sector 62"));


        RouteListAdapter myyAdapter = new RouteListAdapter(RouteListActivity.this, mModelList, RouteListActivity.this);
        mRecyclerView.setAdapter(myyAdapter);


        add_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//

               Dialog dialog = new Dialog(RouteListActivity.this);
                dialog.setContentView(R.layout.add_float);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

                submit =dialog.findViewById(R.id.submit);
                destination =dialog.findViewById(R.id.destination);
                startpoint =dialog.findViewById(R.id.startSource);
                tv_start_time =dialog.findViewById(R.id.event_start_time);
                drop_time_tv =dialog.findViewById(R.id.drop_time_tv);
                timepickerleft =dialog.findViewById(R.id.timepickerleft);
                timepickerright =dialog.findViewById(R.id.timepickerright);
                timepickerleft.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        setStartTime();
                    }
                });
                timepickerright.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setDropTime();
                    }
                });


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String source = startpoint.getText().toString();
                        String pass = destination.getText().toString();

                        if(source.isEmpty()){
                            Toast.makeText(getApplicationContext(),"Enter Start Point",Toast.LENGTH_LONG).show();
                        }else if(pass.isEmpty()){
                            Toast.makeText(getApplicationContext(),"Enter End Point",Toast.LENGTH_LONG).show();
                        } else {

//                    Intent i = new Intent(RouteListActivity.this, HomeActivity.class);
//                    startActivity(i);
                        }

                    }
                });









            }
        });




    }




    private void setStartTime() {
        final Calendar cal = Calendar.getInstance();
        if(tv_start_time.getText().toString().length() !=0) {
            String time[] = tv_start_time.getText().toString().split("\\:+");
            mHour = Integer.parseInt(time[0]);
            mMinute = Integer.parseInt(time[1]);
            mSecond = Integer.parseInt(time[2]);
        }
        else{
        mHour = cal.get(Calendar.HOUR_OF_DAY);
        mMinute = cal.get(Calendar.MINUTE);
        mSecond = cal.get(Calendar.SECOND);
        }
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        tv_start_time.setText((hourOfDay < 10 ? ("0" + hourOfDay) : (hourOfDay)) + ":" + (minute < 10 ? ("0" + minute) : (minute)));
                    }
                }, mHour, mMinute, false);

        timePickerDialog.show();
    }

    private void setDropTime() {
        final Calendar c = Calendar.getInstance();
        if(drop_time_tv.getText().toString().length() !=0) {
            String time2[] = drop_time_tv.getText().toString().split("\\:+");
            mHour2 = Integer.parseInt(time2[0]);
            mMinute2 = Integer.parseInt(time2[1]);
            mSecond2 = Integer.parseInt(time2[2]);
        }
        else{
            mHour2 = c.get(Calendar.HOUR_OF_DAY);
            mMinute2 = c.get(Calendar.MINUTE);
            mSecond2 = c.get(Calendar.SECOND);
        }
        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog2 = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        drop_time_tv.setText((hourOfDay < 10 ? ("0" + hourOfDay) : (hourOfDay)) + ":" + (minute < 10 ? ("0" + minute) : (minute)));
                    }
                }, mHour2, mMinute2, false);

        timePickerDialog2.show();
    }



    @Override
    public void onClick() {
        startActivity(new Intent(RouteListActivity.this, Route_DetailActivity.class));

    }
}
