package com.jat.exam.model;

public class SubjectDescript {
    private String descript;

    public SubjectDescript(String descript) {
        if(descript==null){
            descript="";
        }
        this.descript = descript;
    }

    public String getDescript() {
        return descript;
    }

    @Override
    public String toString() {
        return descript;
    }
}
