package org.firstinspires.ftc.teamA;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import utils.AlphaPantherOp;

@Autonomous
public class autoDistanceTests extends AlphaPantherOp
{

    @Override
    public void runOpMode()
    {

        initRobot();
        setSleepPostMove(true);

        boolean move1 = false;
        boolean move2 = false;
        boolean move3 = false;

        waitForStart();


        /**
         * If all goes well, the following routine should get the robot to move and return to its initial position (or whereabouts)
         */

        while(opModeIsActive() && !move1)
        {
            move1 = gamepad1.a;
        }
        sleep(500);
        telemetry.addLine("Move 1");
        telemetry.update();
        tankDrive(500, 0.5);

        while(opModeIsActive() && !move2)
        {
            move2 = gamepad1.a;
        }
        sleep(500);
        telemetry.addLine("Move 2");
        telemetry.update();
        strafeDrive(500, 0.5);

        while(opModeIsActive() && !move3)
        {
            move3 = gamepad1.a;
        }
        sleep(500);
        telemetry.addLine("Move 3");
        telemetry.update();
        linearDrive(-500,-500, 0.5);

    }
}
