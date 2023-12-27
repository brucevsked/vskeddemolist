package com.jat.demo3;

/**
 * 每次都懒加载
 */
public class EveryTime {
    private String sleepName;
    private String area;
    private int width;
    private int height;

    public EveryTime() {
    }

    public EveryTime(String sleepName, String area, int width, int height) {
        this.sleepName = sleepName;
        this.area = area;
        this.width = width;
        this.height = height;

    }

    public String getSleepName() {
        return sleepName;
    }

    public void setSleepName(String sleepName) {
        this.sleepName = sleepName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "EveryTime{" +
                "sleepName='" + sleepName + '\'' +
                ", area='" + area + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}'+getClass();
    }
}
