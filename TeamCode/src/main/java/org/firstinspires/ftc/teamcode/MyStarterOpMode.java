package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

class MyStarterOpMode extends LinearOpMode {

    private DcMotor leftFront;
    private DcMotor rightFront;
    private DcMotor leftBack;
    private DcMotor rightBack;

    //This is your bare-bones op-mode class
    @Override //Don't forget this, it is necessary
    public void runOpMode()
    {
        leftFront = hardwareMap.get(DcMotor.class, "lf");
        rightFront = hardwareMap.get(DcMotor.class, "rf");
        leftBack = hardwareMap.get(DcMotor.class, "lb");
        rightBack = hardwareMap.get(DcMotor.class, "rb");


        waitForStart();
        while(opModeIsActive())
        {
            double tank = 0; //'tank' for tank drive value
            double turn = 0;

            tank = -this.gamepad1.left_stick_y; //the joystick is a bit weird, when at top, it returns -1
            turn = this.gamepad1.right_stick_x;

            double lfPower, rfPower, lbPower, rbPower;

            lfPower = tank + turn;
            rfPower = tank - turn;
            lbPower = tank + turn;
            rbPower = tank - turn;

            leftFront.setPower(Range.clip(lfPower, -1., 1.)); //make sure your values don't go beyond -1 or 1
            rightFront.setPower(Range.clip(rfPower, -1., 1.));
            leftBack.setPower(Range.clip(lbPower, -1., 1.));
            rightBack.setPower(Range.clip(rbPower, -1., 1.));


            //Telemetry allows us to display info to the driver

            telemetry.addData("Left Front: ", leftFront.getPower());
            telemetry.addData("Right Front: ", rightFront.getPower());
            telemetry.addData("Left Back: ", leftBack.getPower());
            telemetry.addData("Right Back: ", rightBack.getPower());

            //all previously displayed telemetry is deleted and replaced will all the above
            telemetry.update();
        }

    }

}
