package com.vsked.system;

public class Id {

    private Long id;

    public Id(Long id) {
        if(id==null){
            throw new IllegalArgumentException("id not be null！");
        }
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String toString() {
        return id+"";
    }
}
