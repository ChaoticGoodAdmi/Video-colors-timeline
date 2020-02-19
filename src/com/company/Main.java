package com.company;


import com.company.Image.ColorUtilities;
import com.company.Image.ImageEncoder;
import com.company.Image.ImageSequence;
import com.company.Util.DirectoryUtilities;
import com.company.Video.VideoFile;
import com.company.Video.VideoSplitter;
import org.apache.commons.io.FilenameUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        VideoFile videoFile = new VideoFile("D:\\app\\1.mp4");
        VideoSplitter videoSplitter = new VideoSplitter(videoFile);
        String framesDirectory = videoSplitter.splitVideoFile();
        System.out.println(framesDirectory);
        ImageSequence sequence = new ImageSequence();
        Color[] colors = sequence.makeColorsArray(framesDirectory);

    }
}
