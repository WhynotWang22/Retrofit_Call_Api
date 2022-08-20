package com.whynotquang.quangndph14804_thi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.whynotquang.quangndph14804_thi.Adapter.Studen_Adapter;
import com.whynotquang.quangndph14804_thi.Model.Student;
import com.whynotquang.quangndph14804_thi.SQL.Sql;

import java.util.ArrayList;
import java.util.List;

public class TinhtrungbinhActivity extends AppCompatActivity {

    Sql sql;
    private TextView txtTrungbinh;
    private TextView txtMaxvan;
    private TextView txtMinvan;
    RecyclerView recyclerView_st;
    List<Student> studentList;
    Context context;
    public static List<Student> dsSV = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhtrungbinh);
        txtTrungbinh =  findViewById(R.id.txt_trungbinh);
        txtMaxvan = (TextView) findViewById(R.id.txt_maxvan);
        txtMinvan = (TextView) findViewById(R.id.txt_minvan);
        sql = new Sql(this);
        dsSV = sql.getAllStudent();
//         recyclerView_st = findViewById(R.id.recycler_student);
//         recyclerView_st.hasFixedSize();
//         recyclerView_st.setLayoutManager(new LinearLayoutManager(this));
//         Studen_Adapter studen_adapter = new Studen_Adapter(context,studentList);
//          recyclerView_st.setAdapter(studen_adapter);
        txtTrungbinh.setText("Điểm trung binh " +trungbinhtoan());
        txtMaxvan.setText("max diem van 12a:" + maxvan("12b")+"max van 12c:" +maxvan("12c"));
        txtMinvan.setText("min diem van:" +minvan());
          txtTrungbinh.setTextColor(Color.RED);
          txtMinvan.setTextColor(Color.BLUE);
          txtMaxvan.setTextColor(Color.GREEN);
        khoitao();
        trungbinhtoan();


    }
    public void khoitao(){
        Student s = new Student("a","12a","2020","1","a1","a","a","toan",3,8);
        Student s10 = new Student("a","12a","2020","2","a1","a","a","toan",3,8);
        Student s9 = new Student("a","12c","2020","1","a1","a","a","toan",3,9);
        Student s1 = new Student("a2","12a","2020","1","a2","a","b","van",3,8);
        Student s2 = new Student("a3","12a","2020","1","a3","a","c","anh",1,9);
        Student s3 = new Student("a","12b","2020","1","a1","a","a","toan",3,8);
        Student s4 = new Student("a2","12b","2020","1","a2","a","b","van",3,8);
        Student s5 = new Student("a3","12b","2020","1","a3","a","c","anh",1,9);
        Student s6 = new Student("a","12c","2020","1","a1","a","a","toan",3,8);
        Student s7 = new Student("a2","12c","2020","1","a2","a","b","van",3,8);
        Student s8 = new Student("a3","12c","2020","1","a3","a","c","anh",1,9);

        sql.inserSinhVien(s);
        sql.inserSinhVien(s1);
        sql.inserSinhVien(s2);
        sql.inserSinhVien(s3);
        sql.inserSinhVien(s4);
        sql.inserSinhVien(s5);
        sql.inserSinhVien(s6);
        sql.inserSinhVien(s7);
        sql.inserSinhVien(s8);
        sql.inserSinhVien(s9);
        sql.inserSinhVien(s10);


    }
    public  float  trungbinhtoan(){
        float tb=0;
        int count = 0;
        for (Student s: dsSV) {
            if(s.getTenlop().equalsIgnoreCase("12a") || s.getTenlop().equalsIgnoreCase("12b")){
                if(s.getNamhoc().equalsIgnoreCase("2020")&& s.getKyhoc().equalsIgnoreCase("1")){
                    if(s.getTenmon().equalsIgnoreCase("toan")){
                        tb+=s.getDiem();
                        count++;
                    }
                }

            }
        }
        return tb/count;
    }
    public  float  maxvan(String lop) {
        float maxvan = 0;
        int count = 0;
        for (Student s : dsSV) {
            if (s.getTenlop().equalsIgnoreCase(lop) ) {
                if (s.getTenmon().equalsIgnoreCase("van")) {
                    if (s.getNamhoc().equalsIgnoreCase("2020") && s.getKyhoc().equalsIgnoreCase("1")) {
                        if (s.getDiem() > maxvan) {
                            maxvan = s.getDiem();
                        }
                    }
                }
            }


        }
        return maxvan;
    }
    public  float  minvan() {
        float minvan = 10;

        for (Student s : dsSV) {
            if (s.getTenlop().equalsIgnoreCase("12c") || s.getTenlop().equalsIgnoreCase("12a")) {
                if (s.getTenmon().equalsIgnoreCase("van")) {
                    if (s.getNamhoc().equalsIgnoreCase("2020") && s.getKyhoc().equalsIgnoreCase("1")) {
                        if (s.getDiem() <= minvan) {
                            minvan = s.getDiem();
                        }
                    }
                }
            }


        }
        return minvan;
    }
}