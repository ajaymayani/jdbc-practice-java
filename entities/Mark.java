package student_management.entities;

import student_management.services.MarkService;

public class Mark {
    private int mId;
    private int sub1;
    private int sub2;
    private int sub3;
    private int sub4;
    private int sub5;
    private float total;
    private int sId;

    public Mark(){}
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getSub1() {
        return sub1;
    }

    public void setSub1(int sub1) {
        this.sub1 = sub1;
    }

    public int getSub2() {
        return sub2;
    }

    public void setSub2(int sub2) {
        this.sub2 = sub2;
    }

    public int getSub3() {
        return sub3;
    }

    public void setSub3(int sub3) {
        this.sub3 = sub3;
    }

    public int getSub4() {
        return sub4;
    }

    public void setSub4(int sub4) {
        this.sub4 = sub4;
    }

    public int getSub5() {
        return sub5;
    }

    public void setSub5(int sub5) {
        this.sub5 = sub5;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "sub1=" + sub1 +
                ", sub2=" + sub2 +
                ", sub3=" + sub3 +
                ", sub4=" + sub4 +
                ", sub5=" + sub5 +
                ", total=" + total +
                '}';
    }
}
