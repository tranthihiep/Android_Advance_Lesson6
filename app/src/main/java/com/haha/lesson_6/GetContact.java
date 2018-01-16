package com.haha.lesson_6;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by trant on 16/01/2018.
 */

public class GetContact extends AsyncTask<Void, Void, ArrayList<Contact>> {

    private String phoneNumber;
    private Context mContext;
    private RecyclerView mRecycler;
    GetContact(Context context, RecyclerView mRecyclerContacts) {
                this.mContext = context;
                this.mRecycler = mRecyclerContacts;
    }


             @Override
     protected void onPreExecute() {
                super.onPreExecute();
            }

             @Override
     protected ArrayList<Contact> doInBackground(Void... params) {
                 ArrayList<Contact> contacts = new ArrayList<>();
                 Cursor cursor = mContext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                         null, null, null, null);
                 if (cursor != null) {

                     while (cursor.moveToNext()) {
                         String mName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                         phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                         contacts.add(new Contact(mName, phoneNumber));
                     }
                     cursor.close();
                 }
                 return contacts;
             }
             @Override
     protected void onPostExecute(ArrayList<Contact> contacts) {
               super.onPostExecute(contacts);
               ContactAdapter adapter = new ContactAdapter(contacts);
                mRecycler.setAdapter(adapter);
                mRecycler.setLayoutManager(new LinearLayoutManager(mContext));
            }
    public String getPhone(){
        return phoneNumber;
    }
 }

