package org.firstinspires.ftc.teamA;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name= "VisionTester", group="Sky autonomous")
//@Disabled//comment out this line before using
public class VisionTester extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();


    OpenCvCamera phoneCam;
    int width = 640;
    int height = 480;


    @Override
    public void runOpMode() throws InterruptedException
    {
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());



        phoneCam = OpenCvCameraFactory.getInstance().createInternalCamera(OpenCvInternalCamera.CameraDirection.BACK, cameraMonitorViewId);


        phoneCam.openCameraDevice();//open camera
        phoneCam.setPipeline(new EdgeFinderPipeline());//different stages
        phoneCam.startStreaming(width, height, OpenCvCameraRotation.UPRIGHT);//display on RC

        waitForStart();
        runtime.reset();

        while(opModeIsActive())
        {
            telemetry.addLine("What do you see?");
            telemetry.update();
        }

    }

}