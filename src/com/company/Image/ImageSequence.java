package com.company.Image;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageSequence {

    public Color[] makeColorsArray(String directory) throws IOException {
        File file = new File(directory);
        File[] files = file.listFiles();
        assert files != null;
        Color[] averageColors = new Color[files.length];
        for (int i = 0; i < files.length; i++) {
            ImageEncoder encoder = new ImageEncoder();
            Color[][] colors = encoder.fillColors(directory + i + ".jpg");
           averageColors[i] = ColorUtilities.blend(colors);
            System.out.println(averageColors[i].toString());
        }
        return averageColors;
    }

}
