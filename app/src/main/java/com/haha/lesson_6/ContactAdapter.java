package com.haha.lesson_6;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by trant on 16/01/2018.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {
    private ArrayList<Contact> mContacts;

             ContactAdapter(ArrayList<Contact> mListContacts) {
               this.mContacts = mListContacts;
           }

             @Override
     public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact, parent, false);
                 return new ViewHolder(view);
            }

             @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
                 holder.setData(position);
            }

             @Override
     public int getItemCount() {
                return mContacts.size();
            }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTxtName, mTxtNumber;
        ImageButton mBtnCall;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxtName =(TextView) itemView.findViewById(R.id.name);
            mTxtNumber = (TextView) itemView.findViewById(R.id.no);
            mBtnCall = (ImageButton) itemView.findViewById(R.id.btnCall);
        }
        public void setData(int pos){
            mTxtName.setText(mContacts.get(pos).getmName());
            mTxtNumber.setText(mContacts.get(pos).getmNumber());
            
        }
    }
}
