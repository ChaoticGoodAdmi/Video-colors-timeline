package com.company;

import com.company.Image.Graphic;
import com.company.Image.ImageSequence;
import com.company.Util.DirectoryUtilities;
import com.company.Video.VideoFile;
import com.company.Video.VideoSplitter;
import org.apache.commons.io.FilenameUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a path to your video file:");
        Scanner keyboard = new Scanner(System.in);
        String answer = keyboard.nextLine();
        VideoFile inputFile = new VideoFile(answer);
        if (inputFile.exists()) {
            String timelinePath = inputFile.getParent() + "\\" +
                    FilenameUtils.removeExtension(inputFile.getName()) + ".jpg";
            if (inputFile.getVideoLength() > 0) {
                VideoSplitter videoSplitter = new VideoSplitter(inputFile);
                String framesDirectory = videoSplitter.splitVideoFile();
                ImageSequence sequence = new ImageSequence();
                if (framesDirectory != null) {
                    Color[] colors = sequence.makeColorsArray(framesDirectory);
                    DirectoryUtilities.deleteDirectory(framesDirectory);
                    Graphic graphic = new Graphic();
                    File timelinePicture = graphic.drawTimeline(colors, timelinePath);
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(timelinePicture);
                }
            }
        }
    }
}
