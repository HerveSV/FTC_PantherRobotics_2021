package org.firstinspires.ftc.teamB;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;



@TeleOp

public class test2 extends LinearOpMode
{
    @Override
    public void runOpMode()
    {
        waitForStart();
        while(opModeIsActive())
        {
            telemetry.addLine("Yeeet2");
            telemetry.update();
        }

    }
}
