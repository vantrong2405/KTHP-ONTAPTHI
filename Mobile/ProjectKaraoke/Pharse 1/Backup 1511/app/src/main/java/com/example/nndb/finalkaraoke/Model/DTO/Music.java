package com.example.nndb.finalkaraoke.Model.DTO;

import java.io.Serializable;

public class Music implements Serializable {
    //region Value
    private String MaBH;
    private String TenBH;
    private String CaSi;
    private  boolean YeuThich;
    private String KeyYoutube;
    //endregion;

    //region Constructor
    public Music(String maBH, String tenBH, String caSi, boolean yeuThich, String keyYoutube) {
        this.MaBH = maBH;
        this.TenBH = tenBH;
        this.CaSi = caSi;
        this.YeuThich = yeuThich;
        this.KeyYoutube = keyYoutube;
    }

    public Music() {
    }
    //endregion;

    //region Getter
    public String getMaBH() {
        return MaBH;
    }

    public String getTenBH() {
        return TenBH;
    }

    public String getCaSi() {
        return CaSi;
    }

    public boolean isYeuThich() {
        return YeuThich;
    }

    public String getKeyYoutube() {
        return KeyYoutube;
    }
    //endregion;

    //region Setter

    public void setMaBH(String maBH) {
        MaBH = maBH;
    }

    public void setTenBH(String tenBH) {
        TenBH = tenBH;
    }

    public void setCaSi(String caSi) {
        CaSi = caSi;
    }

    public void setYeuThich(boolean yeuThich) {
        YeuThich = yeuThich;
    }

    public void setKeyYoutube(String keyYoutube) {
        KeyYoutube = keyYoutube;
    }
    //endregion;
}
