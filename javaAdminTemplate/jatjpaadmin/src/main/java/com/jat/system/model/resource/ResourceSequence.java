package com.jat.system.model.resource;

public class ResourceSequence {

    private final Integer sequence;

    public ResourceSequence(Integer sequence) {
        if(sequence==null){
            this.sequence=99;
        }else{
            this.sequence = sequence;
        }
    }

    public Integer getSequence() {
        return sequence;
    }

    public String toString() {
        return "" + sequence;
    }
}
