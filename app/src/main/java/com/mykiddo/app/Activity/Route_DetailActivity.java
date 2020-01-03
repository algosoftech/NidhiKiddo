package com.mykiddo.app.Activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.mykiddo.app.NotifyData;
import com.mykiddo.app.R;
import com.mykiddo.app.Adapter.RouteTimeAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Route_DetailActivity extends AppCompatActivity implements RouteTimeAdapter.ImaggListner {

    TextView tv_forgot;
    Button btn_forgot_password;
    RecyclerView mRecyclerView;

    private ArrayList<NotifyData> mModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_detail);
        btn_forgot_password=(Button)findViewById(R.id.btn_forgot_password);


        mRecyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Route_DetailActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mModelList = new ArrayList<>();
        mModelList.add(new NotifyData("1","Jss College"));
        mModelList.add(new NotifyData("2","Jss College"));
        mModelList.add(new NotifyData("3","Jss College"));
        mModelList.add(new NotifyData("4","Jss College"));
        mModelList.add(new NotifyData("5","Jss College"));
        mModelList.add(new NotifyData("6","Jss College"));
        mModelList.add(new NotifyData("7","Jss College"));
        mModelList.add(new NotifyData("8","Jss College"));
        mModelList.add(new NotifyData("9","Jss College"));
        mModelList.add(new NotifyData("10","Jss College"));
        mModelList.add(new NotifyData("11","Jss College"));
        mModelList.add(new NotifyData("12","Jss College"));
        mModelList.add(new NotifyData("13","Jss College"));
        mModelList.add(new NotifyData("14","Jss College"));



        RouteTimeAdapter myyAdapter = new RouteTimeAdapter(Route_DetailActivity.this, mModelList, Route_DetailActivity.this);
        mRecyclerView.setAdapter(myyAdapter);


    }





    @Override
    public void onClick() {
//        startActivity(new Intent(getActivity(),NotificationDetailPageActiviy.class));

    }


    }

