package com.whynotquang.quangndph14804_thi.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.whynotquang.quangndph14804_thi.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class Sql extends SQLiteOpenHelper {

    public static String DBNAME = "dbStudent",TBLOP="lop",TBSV="sinhvien",
     TBMON="monhoc",TBDIEM="bangdiem";

    private SQLiteDatabase db;


    public Sql(@Nullable Context context) {
        super(context, DBNAME, null, 1);
        db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        TBLOP = "Create table lop ( malop Text ,tenlop Text, namhoc text,kyhoc text )";
        db.execSQL(TBLOP);
        TBSV = "Create table SINHVIEN (masv Text  , malop Text references LOP(malop), tensv Text )";
        db.execSQL(TBSV);
        TBMON = "Create table MONHOC (mamon Text , tenmon Text , sotinchi INTEGER ) ";
        db.execSQL(TBMON);
        TBDIEM = "Create table BANGDIEM (masv Text references SINHVIEN(masv), mamon Text references MONHOC(mamon), diem Float ) ";
        db.execSQL(TBDIEM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("Drop table if exists " + TBLOP);
     db.execSQL("Drop table if exists " + TBSV);
     db.execSQL("Drop table if exists " + TBMON);
     db.execSQL("Drop table if exists " + TBDIEM);
    }
    public void inserSinhVien(Student st){
        ContentValues values1 = new ContentValues();
        ContentValues values2 = new ContentValues();
        ContentValues values3 = new ContentValues();
        ContentValues values4 = new ContentValues();
        values1.put("malop",st.getMalop());
        values1.put("tenlop",st.getTenlop());
        values1.put("namhoc",st.getNamhoc());
        values1.put("kyhoc",st.getKyhoc());
        values2.put("masv",st.getMasv());
        values2.put("tensv",st.getTensv());
        values3.put("mamon",st.getMamon());
        values3.put("tenmon",st.getTenmon());
        values3.put("sotinchi",st.getTinchi());
        values4.put("diem",st.getDiem());
        db.insert(TBLOP,null,values1);
        db.insert(TBSV,null,values2);
        db.insert(TBMON,null,values3);
        db.insert(TBDIEM,null,values4);
    }
    public List<Student> getAllStudent(){
        List<Student> ds = new ArrayList<>();
        Cursor c = db.query(TBLOP, null, null, null, null, null, null);
        Cursor c2 = db.query(TBSV, null, null, null, null, null, null);
        Cursor c3 = db.query(TBMON, null, null, null, null, null, null);
        Cursor c4 = db.query(TBDIEM, null, null, null, null, null, null);
        c.moveToFirst();
        c2.moveToFirst();
        c3.moveToFirst();
        c4.moveToFirst();
        while (c.isAfterLast()== false && c2.isAfterLast() == false && c3.isAfterLast() ==false && c4.isAfterLast() ==false){
            Student s = new Student();
            s.setMalop(c.getString(0));
            s.setTenlop(c.getString(1));
            s.setNamhoc(c.getString(2));
            s.setKyhoc(c.getString(3));
            s.setMasv(c2.getString(0));
            s.setTensv(c2.getString(2));
            s.setMamon(c3.getString(0));
            s.setTenmon(c3.getString(1));
            s.setTinchi(c3.getInt(2));
            s.setDiem(c4.getFloat(2));
            ds.add(s);
            Log.d("//=====", s.toString());
            c.moveToNext();
            c2.moveToNext();
            c3.moveToNext();
            c4.moveToNext();
        }
        c.close();
        c2.close();
        c3.close();
        c4.close();
        return ds;
    }
}
