package com.example.health_my.adpater;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.health_my.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.ByqBase;

import java.util.ArrayList;
import java.util.List;

public class MyBingadapter extends RecyclerView.Adapter<MyBingadapter.myViewHolder> {
    private ArrayList<ByqBase> list;
    private Context context;
    private View view;
    private Uri parse;

    public MyBingadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
    public void AddAll(List<ByqBase>byqBases){
        if (byqBases!=null){
            list.addAll(byqBases);
        }
    }


    @NonNull
    @Override
    public MyBingadapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.bbbb_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBingadapter.myViewHolder holder, int position) {
        parse = Uri.parse(list.get(position).disease);
        holder.simpleDraweeView.setImageURI(parse);
        holder.textView.setText(list.get(position).collectionNum);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simpleDraweeView;
        private final TextView textView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.sv);
            textView = itemView.findViewById(R.id.textkong);
        }
    }

}
