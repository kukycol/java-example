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


        String sourceImagePath = "D:\\PlateDetect\\1d302edf48c64901b3990e2913a8a52d.jpg";
        String mirImagePath = "aa.jpg";
        /*图片翻转，type=1镜像翻转，type=0水平翻转*/
//        ImageUtil.overturn(sourceImagePath,mirImagePath,0);

        /*图片旋转,degrees=0,90度;+1等于加90*/
//        ImageUtil.rotate(sourceImagePath,mirImagePath,10);

        /*图片矩形裁剪*/
//        ImageUtil.tailor(new TailorBean(0,0,300,300,sourceImagePath,mirImagePath));

        /*图片圆形裁剪*/
        ImageUtil.circleTailor(new TailorBean(80,80,200,sourceImagePath,mirImagePath));


    }
}
