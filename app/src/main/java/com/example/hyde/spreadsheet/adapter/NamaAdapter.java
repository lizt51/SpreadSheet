package com.example.hyde.spreadsheet.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hyde.spreadsheet.R;
import com.example.hyde.spreadsheet.UserItem;

import java.util.List;

public class NamaAdapter extends RecyclerView.Adapter<NamaAdapter.MyHolder> {
    private List<UserItem> myData;

    public NamaAdapter(List<UserItem> data) {
        this.myData=data;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_nama, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nama.setText(myData.get(position).nama);

    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView nama;
        public MyHolder(View itemView) {
            super(itemView);
            nama = (TextView)itemView.findViewById(R.id.texs1);
        }
    }
}
