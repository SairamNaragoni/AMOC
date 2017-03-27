package com.example.onlinetreasurehunt2;

/**
 * Created by sandeepvarma on 27-03-2017.
 */

public class Data {

    String dataId;
    String dataName;

    public Data(){

    }

    public Data(String dataId, String dataName) {
        this.dataId = dataId;
        this.dataName = dataName;
    }

    public String getDataId() {
        return dataId;
    }

    public String getDataName() {
        return dataName;
    }
}
