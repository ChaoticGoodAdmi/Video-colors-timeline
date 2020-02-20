package com.company;

import com.company.Image.Graphic;
import com.company.Image.ImageSequence;
import com.company.Util.DirectoryUtilities;
import com.company.Video.VideoFile;
import com.company.Video.VideoSplitter;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        VideoFile videoFile = new VideoFile("D:\\app\\avatar101.mkv");
        if (videoFile.getVideoLength() > 0) {
            VideoSplitter videoSplitter = new VideoSplitter(videoFile);
            String framesDirectory = videoSplitter.splitVideoFile();
            ImageSequence sequence = new ImageSequence();
            if (!framesDirectory.equals(null)) {
                Color[] colors = sequence.makeColorsArray(framesDirectory);
                DirectoryUtilities.deleteDirectory(framesDirectory);
                Graphic graphic = new Graphic();
                graphic.drawTimeline(colors);
                Desktop desktop = Desktop.getDesktop();
                desktop.open(new File("C:\\result.jpg"));
            }
        }
    }
}
