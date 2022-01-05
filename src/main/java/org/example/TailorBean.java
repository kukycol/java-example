package org.example;


public class TailorBean {

    //定位x轴
    private int xCoordinate = 0;
    //定位y轴
    private int yCoordinate = 0;
    //裁剪x轴位置
    private int xLength = 0;
    //裁剪y轴位置
    private int yLength = 0;
    //圆的半径
    private int radius = 1;
    //原图片
    private String sourceImagePath ;
    //裁剪后的图片
    private String mirImagePath ;

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxLength() {
        return xLength;
    }

    public void setxLength(int xLength) {
        this.xLength = xLength;
    }

    public int getyLength() {
        return yLength;
    }

    public void setyLength(int yLength) {
        this.yLength = yLength;
    }

    public String getSourceImagePath() {
        return sourceImagePath;
    }

    public void setSourceImagePath(String sourceImagePath) {
        this.sourceImagePath = sourceImagePath;
    }

    public String getMirImagePath() {
        return mirImagePath;
    }

    public void setMirImagePath(String mirImagePath) {
        this.mirImagePath = mirImagePath;
    }

    public TailorBean() {
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public TailorBean(int xCoordinate, int yCoordinate, int radius, String sourceImagePath, String mirImagePath) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.radius = radius;
        this.sourceImagePath = sourceImagePath;
        this.mirImagePath = mirImagePath;
    }

    public TailorBean(int xCoordinate, int yCoordinate, int xLength, int yLength, String sourceImagePath, String mirImagePath) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.xLength = xLength;
        this.yLength = yLength;
        this.sourceImagePath = sourceImagePath;
        this.mirImagePath = mirImagePath;
    }
}
