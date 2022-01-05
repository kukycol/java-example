package org.example;


import java.awt.*;

public class WatermarkBean {
    //是否是水印循环
    private boolean isCirculation;
    //水平水印之间的间隔
    private int xiInterval;
    //垂直水印之间的间隔
    private int yiInterval;
    //偏移量x轴
    private int xCoordinate = 0;
    //偏移量y轴
    private int yCoordinate = 0;
    //颜色
    private Color color;
    //水印字体
    private String fontName;
    //字体分隔
    private int fontStyle;
    //字体大小
    private int fontSize=24;
    //水印文字
    private String pressText;
    //原图片
    private String sourceImagePath ;
    //裁剪后的图片
    private String mirImagePath ;
    //水印图片
    private String waterImagePath ;

    public WatermarkBean() {
    }


    /**
     * 单文字水印
     * @param xCoordinate x轴偏移量
     * @param yCoordinate y轴偏移量
     * @param color 文字颜色
     * @param fontName 字体类型
     * @param fontStyle 字体样式
     * @param fontSize 字体大小
     * @param pressText 水印文字
     * @param sourceImagePath 原图片
     * @param mirImagePath 输出图片
     */
    public WatermarkBean(int xCoordinate, int yCoordinate, Color color, String fontName, int fontStyle, int fontSize, String pressText, String sourceImagePath, String mirImagePath) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
        this.fontName = fontName;
        this.fontStyle = fontStyle;
        this.fontSize = fontSize;
        this.pressText = pressText;
        this.sourceImagePath = sourceImagePath;
        this.mirImagePath = mirImagePath;
    }


    /**
     * 循环文字水印
     * @param isCirculation 是否是循环，默认false
     * @param xiInterval 水平间隔
     * @param yiInterval 垂直间隔
     * @param xCoordinate x轴偏移量
     * @param yCoordinate y轴偏移量
     * @param color 文字颜色
     * @param fontName 字体类型
     * @param fontStyle 字体样式
     * @param fontSize 字体大小
     * @param pressText 水印文字
     * @param sourceImagePath 原图片
     * @param mirImagePath 输出图片
     */
    public WatermarkBean(boolean isCirculation, int xiInterval, int yiInterval, int xCoordinate, int yCoordinate, Color color, String fontName, int fontStyle, int fontSize, String pressText, String sourceImagePath, String mirImagePath) {
        this.isCirculation = isCirculation;
        this.xiInterval = xiInterval;
        this.yiInterval = yiInterval;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.color = color;
        this.fontName = fontName;
        this.fontStyle = fontStyle;
        this.fontSize = fontSize;
        this.pressText = pressText;
        this.sourceImagePath = sourceImagePath;
        this.mirImagePath = mirImagePath;
    }


    public WatermarkBean(int xCoordinate, int yCoordinate, String sourceImagePath, String mirImagePath, String waterImagePath) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.sourceImagePath = sourceImagePath;
        this.mirImagePath = mirImagePath;
        this.waterImagePath = waterImagePath;
    }


    public String getWaterImagePath() {
        return waterImagePath;
    }

    public void setWaterImagePath(String waterImagePath) {
        this.waterImagePath = waterImagePath;
    }

    public boolean isCirculation() {
        return isCirculation;
    }

    public void setCirculation(boolean circulation) {
        isCirculation = circulation;
    }

    public int getXiInterval() {
        return xiInterval;
    }

    public void setXiInterval(int xiInterval) {
        this.xiInterval = xiInterval;
    }

    public int getYiInterval() {
        return yiInterval;
    }

    public void setYiInterval(int yiInterval) {
        this.yiInterval = yiInterval;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
    }

    public int getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getPressText() {
        return pressText;
    }

    public void setPressText(String pressText) {
        this.pressText = pressText;
    }
}
