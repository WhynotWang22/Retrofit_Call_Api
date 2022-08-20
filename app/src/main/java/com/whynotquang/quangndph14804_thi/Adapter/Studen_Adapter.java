package com.whynotquang.quangndph14804_thi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.whynotquang.quangndph14804_thi.Model.Student;
import com.whynotquang.quangndph14804_thi.R;

import org.w3c.dom.Text;

import java.util.List;

public class Studen_Adapter extends RecyclerView.Adapter<Studen_Adapter.Viewholde> {
    Context context;
    List<Student> studentList;

    public Studen_Adapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public Viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view  = LayoutInflater.from(context).inflate(R.layout.item_student,parent,false);
        return new Viewholde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholde holder, int position) {
     Student student = studentList.get(position);
     holder.txt_maxvan.setText((int) student.getDiem());
     holder.txt_maxvan.setText((int) student.getDiem());
     holder.txt_trungbinh.setText((int) student.getDiem());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class Viewholde extends RecyclerView.ViewHolder {
        TextView txt_trungbinh,txtminvan,txt_maxvan;
        public Viewholde(@NonNull View itemView) {
            super(itemView);
            txtminvan = itemView.findViewById(R.id.txt_minvan);
            txt_trungbinh = itemView.findViewById(R.id.txt_trungbinh);
            txt_maxvan = itemView.findViewById(R.id.txt_maxvan);
        }
    }
}
