package com.haha.lesson_6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import static android.R.attr.phoneNumber;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        GetContact getContact = new GetContact(getApplicationContext(), mRecyclerView);
        getContact.execute();
    }
        protected void setCall(String phone) {
            Intent intentcall = new Intent(Intent.ACTION_CALL);
            intentcall.setData(Uri.parse("tel:" + phone.toString()));
            startActivity(intentcall);
        }
        protected void setSend(String phone){
            Intent intentcall2 = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phone.toString()));
            startActivity(intentcall2);
        }
}
