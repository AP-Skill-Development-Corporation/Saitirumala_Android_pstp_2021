package com.example.retrofittest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewholder>{
    Context ct;
    List<Book> mylist;

    public BooksAdapter(List<Book> bookslist, MainActivity mainActivity) {
        ct = mainActivity;
        mylist = bookslist;
    }

    @NonNull
    @Override
    public BooksAdapter.MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ct).inflate(R.layout.row,parent,false);
        return new MyViewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.MyViewholder holder, int position) {
     holder.tv.setText(mylist.get(position).getBooktitle());

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView tv;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            tv =itemView.findViewById(R.id.textview);

        }
    }
}