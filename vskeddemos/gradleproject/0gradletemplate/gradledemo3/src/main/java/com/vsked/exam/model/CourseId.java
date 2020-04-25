package com.vsked.exam.model;

import com.vsked.exam.shared.ValueObject;

public class CourseId implements ValueObject<CourseId> {
    @Override
    public boolean sameValueAs(CourseId other) {
        return false;
    }
}
