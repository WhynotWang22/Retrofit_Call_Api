package com.whynotquang.quangndph14804_thi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whynotquang.quangndph14804_thi.Model.Abum;
import com.whynotquang.quangndph14804_thi.R;


import java.util.List;

public class Abum_Adapter extends RecyclerView.Adapter<Abum_Adapter.ViewHoloder> {
     Context contextl;
    List<Abum> abumList;

    public Abum_Adapter(Context contextl, List<Abum> abumList) {
        this.contextl = contextl;
        this.abumList = abumList;
    }

    @NonNull
    @Override
    public Abum_Adapter.ViewHoloder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(contextl).inflate(R.layout.item_rec_api,parent,false);
        return new ViewHoloder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Abum_Adapter.ViewHoloder holder, int position) {
        Abum abum = abumList.get(position);
        holder.txt_title.setText(abum.getTitle());
        holder.txt_id.setText(abum.getId());
        holder.txt_userId.setText(abum.getUserId());

    }

    @Override
    public int getItemCount() {
        return abumList.size();
    }

    public class ViewHoloder extends RecyclerView.ViewHolder {
        TextView txt_userId,txt_id,txt_title;
        public ViewHoloder(@NonNull View itemView) {
            super(itemView);
            txt_id = itemView.findViewById(R.id.txt_id);
            txt_userId = itemView.findViewById(R.id.txt_userId);
            txt_title = itemView.findViewById(R.id.txt_title);
        }
    }
}
