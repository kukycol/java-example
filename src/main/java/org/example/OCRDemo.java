package org.example;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static java.awt.image.BufferedImage.*;

public class OCRDemo {
    public static void main(String[] args) throws IOException {


        String sourceImagePath = "src/main/resources/jpg/demo.png";
        String waterImagePath = "src/main/resources/jpg/water.jpg";
        String mirImagePath = "aa.jpg";
        /*图片翻转，type=1镜像翻转，type=0水平翻转*/
//        ImageUtil.overturn(sourceImagePath,mirImagePath,0);

        /*图片旋转,degrees=0,90度;+1等于加90*/
//        ImageUtil.rotate(sourceImagePath,mirImagePath,10);

        /*图片矩形裁剪*/
//        ImageUtil.tailor(new TailorBean(0,0,300,300,sourceImagePath,mirImagePath));

        /*图片圆形裁剪*/
//        ImageUtil.circleTailor(new TailorBean(80,80,200,sourceImagePath,mirImagePath));

        /*图片文字水印*/
        //单个文字
//        ImageUtil.watermark(new WatermarkBean(-89,7000,new Color(44,255, 79),"宋体",0,90,"水印",sourceImagePath,mirImagePath));
        //循环
//        ImageUtil.watermark(new WatermarkBean(true,60,60,0,0,new Color(44,255, 79),"宋体",0,60,"水印",sourceImagePath,mirImagePath));

        /*图片图片水印*/
//        ImageUtil.imageWatermark(new WatermarkBean(500,1000,sourceImagePath,mirImagePath,waterImagePath));
    }
}
