package com.company.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageEncoder {
    BufferedImage image;
    int width;
    int height;

    public Color[][] fillColors(String pathname) throws IOException {
        File input = new File(pathname);
        image = ImageIO.read(input);
        width = image.getWidth();
        height = image.getHeight();
        Color[][] colors = new Color[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Color c = new Color(image.getRGB(j, i));
                colors[i][j] = c;
            }
        }
        return colors;
    }


}