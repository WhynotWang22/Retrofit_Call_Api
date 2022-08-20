package com.whynotquang.quangndph14804_thi.Model;

public class Student {
    private String malop,tenlop,namhoc,kyhoc,masv,tensv,mamon,tenmon;
    private int tinchi;
    private float diem;

    public Student(String malop, String tenlop, String namhoc, String kyhoc, String masv, String tensv, String mamon, String tenmon, int tinchi, float diem) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.namhoc = namhoc;
        this.kyhoc = kyhoc;
        this.masv = masv;
        this.tensv = tensv;
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.tinchi = tinchi;
        this.diem = diem;
    }

    public Student() {
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public String getNamhoc() {
        return namhoc;
    }

    public void setNamhoc(String namhoc) {
        this.namhoc = namhoc;
    }

    public String getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(String kyhoc) {
        this.kyhoc = kyhoc;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getMamon() {
        return mamon;
    }

    public void setMamon(String mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getTinchi() {
        return tinchi;
    }

    public void setTinchi(int tinchi) {
        this.tinchi = tinchi;
    }

    public float getDiem() {
        return diem;
    }

    public void setDiem(float diem) {
        this.diem = diem;
    }
}
