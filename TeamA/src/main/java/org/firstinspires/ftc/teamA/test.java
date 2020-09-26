package org.firstinspires.ftc.teamA;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp

public class test extends LinearOpMode
{
    @Override
    public void runOpMode()
    {

        waitForStart();
        while(opModeIsActive())
        {
            telemetry.addLine("Yeeet1");
            telemetry.update();
        }

    }
}
