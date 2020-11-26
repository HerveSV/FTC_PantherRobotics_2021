package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import utils.Toggle;

@TeleOp
public class servoTest extends LinearOpMode {

    private Servo servo;
    private final double incrStep = 0.05;

    @Override
    public void runOpMode()
    {
        servo = hardwareMap.get(Servo.class, "testServo");

        waitForStart();

        Toggle moveToMax = new Toggle();
        Toggle addMin = new Toggle(), subMin = new Toggle();
        Toggle addMax = new Toggle(), subMax = new Toggle();

        double minPos = 0., maxPos = 1.;

        servo.setPosition(minPos);

        while(opModeIsActive())
        {
            if(addMin.update(gamepad1.dpad_up)) { minPos += incrStep; }
            else if(subMin.update(gamepad1.dpad_down)) { minPos -= incrStep; }
            minPos = Range.clip(minPos, 0., 1.);

            if(addMax.update(gamepad1.dpad_right)) { maxPos += incrStep; }
            else if(subMax.update(gamepad1.dpad_left)) { maxPos -= incrStep; }
            maxPos = Range.clip(maxPos, 0., 1.);


            moveToMax.update(gamepad1.a);

            if(moveToMax.getState())
            {
                servo.setPosition(maxPos);
            }
            else
            {
                servo.setPosition(minPos);
            }

            telemetry.addData("Set to max: ", moveToMax.getState());
            telemetry.addData("Min Position: ", minPos);
            telemetry.addData("Max Position: ", maxPos);
            telemetry.addData("Current Position: ", servo.getPosition());
            telemetry.update();
        }
    }

}
