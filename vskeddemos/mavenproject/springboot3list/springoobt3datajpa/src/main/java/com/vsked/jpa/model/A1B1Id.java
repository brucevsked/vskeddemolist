package com.vsked.jpa.model;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class A1B1Id {
    private Long a1id;
    private Long b1id;
    public A1B1Id() {
    }

    public A1B1Id(long a1id, long b1id) {
        this.a1id = a1id;
        this.b1id = b1id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        A1B1Id a1B1Id = (A1B1Id) o;
        return Objects.equals(a1id, a1B1Id.a1id) && Objects.equals(b1id, a1B1Id.b1id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a1id, b1id);
    }

    public Long getA1id() {
        return a1id;
    }

    public void setA1id(Long a1id) {
        this.a1id = a1id;
    }

    public Long getB1id() {
        return b1id;
    }

    public void setB1id(Long b1id) {
        this.b1id = b1id;
    }
}
