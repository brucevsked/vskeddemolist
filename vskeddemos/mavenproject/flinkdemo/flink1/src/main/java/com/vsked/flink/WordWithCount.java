package com.vsked.flink;

/**
 * 主要为了存储单词以及单词出现的次数
 */
public class WordWithCount{
    public String word;
    public long count;
    public WordWithCount(){}
    public WordWithCount(String word, long count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public String toString() {
        return "WordWithCount{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }
}
