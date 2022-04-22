package com.android.appmusic11.Model;

import java.io.Serializable;

public class BaiHatModel implements Serializable {
    private int MaBaiHat;
    private String TenBaiHat;
    private String HinhBaiHat;
    private String TenCaSi;
    private String LinkBaiHat;

    public BaiHatModel(int maBaiHat, String tenBaiHat, String hinhBaiHat, String tenCaSi, String linkBaiHat) {
        MaBaiHat = maBaiHat;
        TenBaiHat = tenBaiHat;
        HinhBaiHat = hinhBaiHat;
        TenCaSi = tenCaSi;
        LinkBaiHat = linkBaiHat;
    }

    public int getMaBaiHat() {
        return MaBaiHat;
    }

    public void setMaBaiHat(int maBaiHat) {
        MaBaiHat = maBaiHat;
    }

    public String getTenBaiHat() {
        return TenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        TenBaiHat = tenBaiHat;
    }

    public String getHinhBaiHat() {
        return HinhBaiHat;
    }

    public void setHinhBaiHat(String hinhBaiHat) {
        HinhBaiHat = hinhBaiHat;
    }

    public String getTenCaSi() {
        return TenCaSi;
    }

    public void setTenCaSi(String tenCaSi) {
        TenCaSi = tenCaSi;
    }

    public String getLinkBaiHat() {
        return LinkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        LinkBaiHat = linkBaiHat;
    }
}
