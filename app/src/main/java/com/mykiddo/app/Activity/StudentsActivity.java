package com.mykiddo.app.Activity;

import android.os.Bundle;
import android.widget.Button;

import com.mykiddo.app.NotifyData;
import com.mykiddo.app.R;
import com.mykiddo.app.Adapter.StudentsAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentsActivity extends AppCompatActivity implements StudentsAdapter.ImaggListner {

    RecyclerView mRecyclerView;

    private ArrayList<NotifyData> mModelList;

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        mRecyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StudentsActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mModelList = new ArrayList<>();
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));
        mModelList.add(new NotifyData("Shiva Agarwal","Jss College"));



        StudentsAdapter myyAdapter = new StudentsAdapter(StudentsActivity.this, mModelList, StudentsActivity.this);
        mRecyclerView.setAdapter(myyAdapter);


    }





    @Override
    public void onClick() {
//        startActivity(new Intent(getActivity(),NotificationDetailPageActiviy.class));

    }
}
