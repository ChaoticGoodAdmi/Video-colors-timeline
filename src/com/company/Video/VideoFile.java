package com.company.Video;

import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import java.io.File;

public class VideoFile extends File {

    private VideoCapture fileCapture;
    private long videoLength;
    private int framesPerSecond;
    private long frameNumber;
    private String pathname;
    private boolean isOpened;

    public VideoFile(String pathname) {
        super(pathname);
        this.pathname = pathname;
        fileCapture = captureVideoFile();
    }

    private VideoCapture captureVideoFile() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        VideoCapture cap = new VideoCapture();
        cap.open(this.pathname);

        if (cap.isOpened()) {
            System.out.println("Video is opened");
            videoLength = (long) cap.get(Videoio.CAP_PROP_FRAME_COUNT);
            framesPerSecond = (int) cap.get(Videoio.CAP_PROP_FPS);
            frameNumber = (long) cap.get(Videoio.CAP_PROP_POS_FRAMES);

            System.out.println("VideoFile.capture.VideoFile: length=" + videoLength + "; fps=" + framesPerSecond + "/" + frameNumber);
        }
        return cap;
    }

    public void terminateVideoFile() {
        fileCapture.release();
    }

    public long getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(long videoLength) {
        this.videoLength = videoLength;
    }

    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    public void setFramesPerSecond(int framesPerSecond) {
        this.framesPerSecond = framesPerSecond;
    }

    public long getFrameNumber() {
        return frameNumber;
    }

    public void setFrameNumber(long frameNumber) {
        this.frameNumber = frameNumber;
    }

    public VideoCapture getFileCapture() {
        return fileCapture;
    }

    public void setFileCapture(VideoCapture fileCapture) {
        this.fileCapture = fileCapture;
    }
}
