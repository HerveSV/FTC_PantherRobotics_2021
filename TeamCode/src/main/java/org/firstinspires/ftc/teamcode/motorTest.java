package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class motorTest extends LinearOpMode {

    private DcMotor motor;

    @Override
    public void runOpMode()
    {
        motor = hardwareMap.get(DcMotor.class, "testMotor");
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);  //Does not use encoders, motors will generally run faster but will low torque
        //motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);  //Uses encoders, motors will generally run slower but at a controlled and constant speed
        //motor.setMode(DcMotor.RunMode.RUN_TO_POSITION); //Uses encoders, quite useful if you want to get to a certain encoder count and stop.

        waitForStart();

        while(opModeIsActive())
        {
            motor.setPower(this.gamepad1.left_stick_y);
        }
    }

}
