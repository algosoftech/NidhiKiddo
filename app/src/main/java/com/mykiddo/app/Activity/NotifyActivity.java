package com.mykiddo.app.Activity;

import android.os.Bundle;


import android.widget.Button;

import com.mykiddo.app.Adapter.NotifyAdapter;
import com.mykiddo.app.NotifyData;
import com.mykiddo.app.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotifyActivity extends AppCompatActivity implements NotifyAdapter.ImaggListner {

    RecyclerView mRecyclerView;

    private ArrayList<NotifyData> mModelList;

    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        mRecyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(NotifyActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mModelList = new ArrayList<>();
        mModelList.add(new NotifyData("Eclipse Of a golden legacy","It is a establised fact that ..."));
        mModelList.add(new NotifyData("Male Rape","making the System natural"));
        mModelList.add(new NotifyData("Interiocutory Oders","To stay not to story"));
        mModelList.add(new NotifyData("Eclipse of a golden lagecy","It is a being establised fact that ...."));
        mModelList.add(new NotifyData("Male Rape","Making the system natural"));
        mModelList.add(new NotifyData("Interiocutory Oders","To stay not to story"));



        NotifyAdapter myyAdapter = new NotifyAdapter(NotifyActivity.this, mModelList, NotifyActivity.this);
        mRecyclerView.setAdapter(myyAdapter);


    }





    @Override
    public void onClick() {
//        startActivity(new Intent(getActivity(),NotificationDetailPageActiviy.class));

    }
}
