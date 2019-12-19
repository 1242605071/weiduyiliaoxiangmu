package com.example.health_my.adpater;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.health_my.R;
import com.facebook.drawee.view.SimpleDraweeView;
import com.wd.common.bean.InteBase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Mycaixunadapter extends RecyclerView.Adapter<Mycaixunadapter.myViewHolder> {
     private ArrayList<InteBase> list;
     private Context context;
    private View view;
    private Uri parse;

    public Mycaixunadapter( Context context) {
        list = new ArrayList<>();
        this.context = context;
    }
     public void AddAll(List<InteBase> inteBases){
        if (inteBases!=null){
            list.addAll(inteBases);
        }
     }


    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.caina_layout,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        parse = Uri.parse(list.get(position).releaseUserHeadPic);
        holder.simpleDraweeView.setImageURI(parse);
        holder.textView.setText(list.get(position).releaseUserNickName);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class myViewHolder extends RecyclerView.ViewHolder{

         private final TextView textView;
         private final SimpleDraweeView simpleDraweeView;

         public myViewHolder(@NonNull View itemView) {
             super(itemView);
             textView = itemView.findViewById(R.id.zhangsan);
             simpleDraweeView = itemView.findViewById(R.id.dv);

         }
     }
}
