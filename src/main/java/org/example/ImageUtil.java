package org.example;

import com.sun.istack.internal.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageUtil {

    /**
     * @Description: 图片翻转
     * @Author: kuky
     * @Date: 2022/1/5 11:13
     * @param: sourceImagePath 源图片地址
     * @param: mirImagePath 翻转照片
     * @param: type 0水平翻转，1镜像翻转
     * @Return void
     * @Version: 0.0.1
     */
    public static void overturn(String sourceImagePath, String mirImagePath, int type) {
        // 读取图片
        BufferedImage bufImage = null;
        try {
            bufImage = ImageIO.read(new File(sourceImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取图片的宽高
        final int width = bufImage.getWidth();
        final int height = bufImage.getHeight();

        // 读取出图片的所有像素
        int[] rgbs = bufImage.getRGB(0, 0, width, height, null, 0, width);
        switch (type) {
            case 1:
                // 对图片的像素矩阵进行垂直镜像
                for (int row = 0; row < height / 2; row++) {
                    for (int col = 0; col < width; col++) {
                        int temp = rgbs[row * width + col];//
                        rgbs[row * width + col] = rgbs[(height - row - 1) * width + col];
                        rgbs[(height - row - 1) * width + col] = temp;
                    }
                }
                break;
            default:
                // 对图片的像素矩阵进行水平镜像
                for (int row = 0; row < height; row++) {
                    for (int col = 0; col < width / 2; col++) {
                        int temp = rgbs[row * width + col];//
                        rgbs[row * width + col] = rgbs[row * width + (width - 1 - col)];
                        rgbs[row * width + (width - 1 - col)] = temp;
                    }
                }
        }


        // 把水平镜像后的像素矩阵设置回 bufImage
        bufImage.setRGB(0, 0, width, height, rgbs, 0, width);

        // 把修改过的 bufImage 保存到本地
        try {
            String imageType = sourceImagePath.split("\\.")[1].toUpperCase();
            ImageIO.write(bufImage, imageType, new File(mirImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @Description: 图片旋转
     * @Author: kuky
     * @Date: 2022/1/5 11:13
     * @param: sourceImagePath 源图片地址
     * @param: mirImagePath 翻转照片
     * @param: degreesNumber 0=90度，+=90
     * @Return void
     * @Version: 0.0.1
     */
    public static void rotate(String sourceImagePath, String mirImagePath, int degreesNumber) {
        // 读取图片
        BufferedImage bufImage = null;
        try {
            bufImage = ImageIO.read(new File(sourceImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int height = bufImage.getHeight();
        int width = bufImage.getWidth();
        int type = bufImage.getType();


        BufferedImage newImageFromBuffer = new BufferedImage(degreesNumber % 2 == 0 ? height : width, degreesNumber % 2 == 0 ? width : height, type);

        //新建变换（变换的实际效果和代码顺序是反的，下面实际效果是先旋转后平移）
        AffineTransform trans = new AffineTransform();
        //2.由于原点在左上角，所以顺时针旋转90度后图片在可视范围左侧，需向右移动过来
        int tx = degreesNumber % 4 == 0 ? height : (degreesNumber % 4 == 1 ? width : 0);
        int ty = degreesNumber % 4 == 1 ? height : (degreesNumber % 4 == 2 ? width : 0);
        trans.translate(tx, ty);
        //1.原始图片顺时针旋转90度，若想任意角度，请自行修改
        double v = Math.PI * (degreesNumber * 0.5 + 0.5);
        trans.rotate(v);

        //获取新建内存图片的“图形对象”，通过它在内存图片中绘图
        Graphics2D graphics2D = (Graphics2D) newImageFromBuffer.getGraphics();
        //绘图前，先设置变换对象，应用上面的旋转、平移
        graphics2D.setTransform(trans);

        //将老图片，从新图片的原点（0,0）点开始绘制到新图片中
        graphics2D.drawImage(bufImage, 0, 0, null);


        try {
            String imageType = sourceImagePath.split("\\.")[1].toUpperCase();
            ImageIO.write(newImageFromBuffer, imageType, new File(mirImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * @Description: 图片圆形裁剪
     * @Author: kuky
     * @Date: 2022/1/5 16:37
     * @param: tailorBean 裁剪bean
     * @Return void
     * @Version: 0.0.1
     */
    public static void circleTailor(TailorBean tailorBean) {

        // 读取图片
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(tailorBean.getSourceImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int xCoordinate = tailorBean.getxCoordinate();
        int yCoordinate = tailorBean.getyCoordinate();
        int radius = tailorBean.getRadius();

        //判断圆心左右半径是否超限
        if ((xCoordinate + radius) > image.getWidth() || radius > xCoordinate) {
            int a = image.getWidth() - 1 - xCoordinate;
            if (a > xCoordinate) {
                radius = xCoordinate;
            } else {
                radius = a;
            }
        }
        //判断圆心上下半径是否超限
        if ((yCoordinate + radius) > image.getHeight() || radius > yCoordinate) {
            int a = image.getHeight() - 1 - yCoordinate;
            if (a > yCoordinate) {
                radius = yCoordinate;
            } else {
                radius = a;
            }
        }
        int length = 2 * radius + 1;
        BufferedImage resultImage = new BufferedImage(length, length, image.getType());
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int x = i - radius;
                int y = j - radius;
                int distance = (int) Math.sqrt(x * x + y * y);
                if (distance <= radius) {
                    int rgb = image.getRGB(x + xCoordinate, y + yCoordinate);
                    resultImage.setRGB(i, j, rgb);
                }
            }
        }

        try {
            String imageType = tailorBean.getSourceImagePath().split("\\.")[1].toUpperCase();
            ImageIO.write(resultImage, imageType, new File(tailorBean.getMirImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * @Description: 图片矩形裁剪
     * @Author: kuky
     * @Date: 2022/1/5 16:37
     * @param: tailorBean 裁剪bean
     * @Return void
     * @Version: 0.0.1
     */
    public static void tailor(TailorBean tailorBean) {

        // 读取图片
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(tailorBean.getSourceImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = image.getWidth();
        int height = image.getHeight();
        int xCoordinate = tailorBean.getxCoordinate();
        int yCoordinate = tailorBean.getyCoordinate();
        int xLength = tailorBean.getxLength();
        int yLength = tailorBean.getyLength();

        //判断x、y方向是否超过图像最大范围
        if ((xCoordinate + xLength) >= width) {
            xLength = width - xCoordinate;
        }
        if ((yCoordinate + yLength) >= height) {
            yLength = height - yCoordinate;
        }
        BufferedImage resultImage = new BufferedImage(xLength, yLength, image.getType());
        for (int x = 0; x < xLength; x++) {
            for (int y = 0; y < yLength; y++) {
                int rgb = image.getRGB(x + xCoordinate, y + yCoordinate);
                resultImage.setRGB(x, y, rgb);
            }
        }

        try {
            String imageType = tailorBean.getSourceImagePath().split("\\.")[1].toUpperCase();
            ImageIO.write(resultImage, imageType, new File(tailorBean.getMirImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加文字水印
     *
     * @param a 水印bean
     */
    public static void watermark(WatermarkBean a) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(a.getSourceImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int height = image.getHeight();
        int width = image.getWidth();

        //定位不能超出边框
        if ((a.getxCoordinate() + a.getFontSize() * a.getPressText().length()) >= width) {
            a.setxCoordinate(width - a.getFontSize() * a.getPressText().length());
        }
        if ((a.getyCoordinate() + a.getFontSize()) >= height) {
            a.setyCoordinate(height - 10);
        }
        if (a.getyCoordinate() <= 0) {
            a.setyCoordinate(a.getFontSize());
        }
        if (a.getxCoordinate() < 0) {
            a.setxCoordinate(0);
        }

        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(image, 0, 0, width, height, null);
        graphics.setColor(a.getColor());
        graphics.setFont(new Font(a.getFontName(), a.getFontStyle(), a.getFontSize()));
        if (a.isCirculation()) {
            a.setxCoordinate(0);
            a.setyCoordinate(a.getFontSize());
            int x = (width / (a.getxCoordinate() + a.getFontSize() * a.getPressText().length() + a.getXiInterval())) + 1;
            int y = (height / (a.getyCoordinate() + a.getFontSize())) + 1;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j <= y; j++) {
                    int xc = i > 0 ? (a.getxCoordinate() + (i * (a.getFontSize() * a.getPressText().length() + a.getXiInterval()))) : a.getxCoordinate();
                    int yc = j > 0 ? (a.getyCoordinate() + (j * (a.getyCoordinate() + a.getYiInterval()))) : a.getyCoordinate();
                    graphics.drawString(a.getPressText(), xc, yc);
                }
            }
        } else {
            graphics.drawString(a.getPressText(), a.getxCoordinate(), a.getyCoordinate());
        }
        graphics.dispose();


        try {
            String imageType = a.getSourceImagePath().split("\\.")[1].toUpperCase();
            ImageIO.write(image, imageType, new File(a.getMirImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 添加图片水印
     * @param a 水印bean
     */
    public static void imageWatermark(WatermarkBean a){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(a.getSourceImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int height = image.getHeight();
        int width = image.getWidth();

        Graphics2D graphics = image.createGraphics();
        graphics.drawImage(image, 0, 0, width, height, null);


        BufferedImage waterImage = null;
        try {
            waterImage = ImageIO.read(new File(a.getWaterImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ((a.getxCoordinate() + waterImage.getWidth()) >= width) {
            a.setxCoordinate(width - waterImage.getWidth());
        }
        if ((a.getyCoordinate() + waterImage.getHeight()) >= height) {
            a.setyCoordinate(height - waterImage.getHeight());
        }

        if (a.getyCoordinate() < 0) {
            a.setyCoordinate(0);
        }
        if (a.getxCoordinate() < 0) {
            a.setxCoordinate(0);
        }

        graphics.drawImage(waterImage,a.getxCoordinate(),a.getyCoordinate(),waterImage.getWidth(),waterImage.getHeight(),null);
        graphics.dispose();


        try {
            String imageType = a.getSourceImagePath().split("\\.")[1].toUpperCase();
            ImageIO.write(image, imageType, new File(a.getMirImagePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
