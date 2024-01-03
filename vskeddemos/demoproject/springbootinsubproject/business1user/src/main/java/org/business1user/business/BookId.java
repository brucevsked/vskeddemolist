package org.business1user.business;

public class BookId {
    private String id;

    public BookId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BookId{" +
                "id='" + id + '\'' +
                '}';
    }
}
