package com.company.Image;

import java.awt.*;

public class ColorUtilities {

    public static Color blend(Color[][] colors) {
        double totalAlpha = 0;
        double r = 0;
        double g = 0;
        double b = 0;
        double a = 0;
        int countX = colors.length;
        int countY = colors[0].length;
        for (Color[] colorRow : colors) {
            for (Color color : colorRow) {
                if (color != null) {
                    totalAlpha += color.getAlpha();
                }
            }
        }
        double[][] weights = new double[countX][countY];
        for (int i = 0; i < countX; i++) {
            for (int j = 0; j < countY; j++) {
                weights[i][j] = colors[i][j].getAlpha() / totalAlpha;
                r += weights[i][j] * colors[i][j].getRed();
                g += weights[i][j] * colors[i][j].getGreen();
                b += weights[i][j] * colors[i][j].getBlue();
                a = Math.max(a, colors[i][j].getAlpha());
            }
        }
        return new Color((int) r, (int) g, (int) b, (int) a);
    }
}
