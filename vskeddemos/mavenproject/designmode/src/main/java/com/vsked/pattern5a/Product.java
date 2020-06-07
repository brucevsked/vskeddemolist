package com.vsked.pattern5a;

/**
 *  this is 具体的产品---房子
 *
 */
public class Product {
	/**
	 * this is 地基
	 */
    private String basic;
    
    /**
     * this is 墙
     */
    private String wall;
    
    /**
     * this is 楼顶
     */
    private String roofed;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }
    
}
