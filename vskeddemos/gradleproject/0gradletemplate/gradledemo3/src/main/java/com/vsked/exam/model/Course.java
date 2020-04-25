package com.vsked.exam.model;

import com.vsked.exam.shared.Entity;

public class Course implements Entity<Course> {
    @Override
    public boolean sameIdentityAs(Course other) {
        return false;
    }
}
