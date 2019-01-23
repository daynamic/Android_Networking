package com.example.retrofitsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Aks on 23/01/2019.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<RetroUsers> dataList;

    public MyAdapter(List<RetroUsers> dataList){
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        //Get a reference to the Views in our layout//
        public final View myView;
        TextView textUser;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            textUser = myView.findViewById(R.id.user);
        }
    }

    //Construct a RecyclerView.ViewHolder//
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }

    //Set the data
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textUser.setText(dataList.get(position).getUser());
    }

    //Calculate the item count for the RecylerView
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
