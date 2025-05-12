package com.vsked.test.jdk;

public record BookRecord(
        Long id,
        String name,
        String type,
        String author
) {

    public static class Builder {
        private Long id;
        private String name;
        private String type;
        private String author;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public BookRecord build() {
            return new BookRecord(id, name, type, author);
        }
    }
}