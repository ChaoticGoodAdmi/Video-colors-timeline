package com.company.Image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Graphic {

    public File drawTimeline(Color[] colors) throws IOException {
        int width;
        int height;
        int position = 0;
        final String resultPath = "C:\\result.jpg";
        width = colors.length;
        height = 300;
        BufferedImage bufferedImage = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        for (Color color :
                colors) {
            g2d.setColor(color);
            g2d.fillRect(position, 0, 1, height);
            position++;
        }
        g2d.dispose();
        File file = new File(resultPath);
        ImageIO.write(bufferedImage, "jpg", file);
        return file;
    }
}
