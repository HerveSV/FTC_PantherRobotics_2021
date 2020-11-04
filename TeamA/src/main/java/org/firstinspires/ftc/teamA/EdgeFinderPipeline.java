package org.firstinspires.ftc.teamA;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgcodecs.Imgcodecs;
import org.openftc.easyopencv.OpenCvPipeline;

public class EdgeFinderPipeline extends OpenCvPipeline {

    private Mat src = new Mat();
    private Mat grayscale = new Mat();
    private Mat gradient = new Mat();

    int scale = 1;
    int delta = 0;
    int ddepth = CvType.CV_16S;


    @Override
    public Mat processFrame(Mat input) {

        //Remove noise
        Imgproc.GaussianBlur(input, src, new Size(3, 3), 0, 0, Core.BORDER_DEFAULT);

        //Covert to grayscale
        Imgproc.cvtColor(src, grayscale, Imgproc.COLOR_RGB2GRAY);

        Mat gradX = new Mat(), gradY = new Mat();
        Mat abs_gradX = new Mat(), abs_gradY = new Mat();

        Imgproc.Scharr(grayscale, gradX, ddepth, 1, 0, scale, delta, Core.BORDER_DEFAULT);
        //Imgproc.Sobel(grayscale, gradX, ddepth, 1, 0, 3, scale, delta, Core.BORDER_DEFAULT);

        Imgproc.Scharr(grayscale, gradY, ddepth, 0, 1, scale, delta, Core.BORDER_DEFAULT);
        //Imgproc.Sobel(grayscale, grady, ddepth, 0, 1, 3, scale, delta, Core.BORDER_DEFAULT);

        Core.convertScaleAbs(gradX, abs_gradX);
        Core.convertScaleAbs(gradY, abs_gradY);

        Core.addWeighted(abs_gradX, 0.5, abs_gradY, 0.5, 0, gradient);

        return gradient;

    }
}
