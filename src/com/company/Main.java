package com.company;

import com.company.Image.Graphic;
import com.company.Image.ImageSequence;
import com.company.Util.DirectoryUtilities;
import com.company.Video.VideoFile;
import com.company.Video.VideoSplitter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        VideoFile videoFile = new VideoFile("D:\\app\\avatar101.mkv");
        String timelinePath = videoFile.getParent() + "\\" +
                FilenameUtils.removeExtension(videoFile.getName()) + ".jpg";
        System.out.println("timeline: " + timelinePath);
        if (videoFile.getVideoLength() > 0) {
            VideoSplitter videoSplitter = new VideoSplitter(videoFile);
            String framesDirectory = videoSplitter.splitVideoFile();
            ImageSequence sequence = new ImageSequence();
            if (framesDirectory != null) {
                Color[] colors = sequence.makeColorsArray(framesDirectory);
                DirectoryUtilities.deleteDirectory(framesDirectory);
                Graphic graphic = new Graphic();
                File timelinePicture = graphic.drawTimeline(colors, timelinePath);
                System.out.println(timelinePicture.getAbsolutePath());
                Desktop desktop = Desktop.getDesktop();
                desktop.open(timelinePicture);
            }
        }
    }
}
