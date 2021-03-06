package com.company.Video;

import com.company.Util.DirectoryUtilities;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class VideoSplitter {

    private VideoFile videoFile;
    private String outputDirectory = "D:\\app\\";

    public VideoSplitter(VideoFile videoFile) {
        this.videoFile = videoFile;
        outputDirectory += FilenameUtils.removeExtension(videoFile.getName()) + "\\";
    }

    public String splitVideoFile() {
        String framesDirectory = null;
        VideoCapture cap = videoFile.getFileCapture();
        long frameNumber = videoFile.getFrameNumber();
        long videoLength = videoFile.getVideoLength();
        int fps = videoFile.getFramesPerSecond();
        System.out.println(videoLength);
        int savedFrameNumber = 0;
        Mat frame = new Mat();
        if (cap.isOpened()) {
            if (checkDirectory(outputDirectory)) {
                if (new File(outputDirectory).mkdir()) {
                    System.out.println("Converting Video...");
                    while (frameNumber <= videoLength) {
                        for (int i = 0; i < fps; i++) {
                            cap.read(frame);
                            frameNumber++;
                        }
                        if(!frame.empty()) {
                            Imgcodecs.imwrite(outputDirectory + "" + savedFrameNumber + ".jpg", frame);
                            savedFrameNumber++;
                        }
                    }
                    videoFile.terminateVideoFile();
                    System.out.println(videoLength + " Frames extracted");
                }
            }
            framesDirectory = outputDirectory;
        } else {
            System.out.println("Fail");
        }
        return framesDirectory;
    }

    private boolean checkDirectory(String outputDir) {
        File output = new File(outputDir);
        if (output.exists() && Objects.requireNonNull(output.listFiles()).length > 0) {
            System.out.println(outputDir);
            System.out.println("This videofile has been split already. Do you want to do it again? y/n");
            Scanner keyboard = new Scanner(System.in);
            String answer = keyboard.nextLine();
            if (answer.equals("y")) {
                DirectoryUtilities.deleteDirectory(outputDir);
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
}
