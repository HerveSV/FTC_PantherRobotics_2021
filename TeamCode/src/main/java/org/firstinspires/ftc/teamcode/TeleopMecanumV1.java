package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import utils.Toggle;


@TeleOp
public class TeleopMecanumV1 extends LinearOpMode
{
    private DcMotor lfWheel, rfWheel, lbWheel, rbWheel;
    private DcMotor lIntake, rIntake;

    @Override
    public void runOpMode(){

        lfWheel = hardwareMap.get(DcMotor.class, "lf");
        rfWheel = hardwareMap.get(DcMotor.class, "rf");
        lbWheel = hardwareMap.get(DcMotor.class, "lb");
        rbWheel = hardwareMap.get(DcMotor.class, "rb");

        lIntake = hardwareMap.get(DcMotor.class, "lIntake");
        rIntake = hardwareMap.get(DcMotor.class, "rIntake");

        lfWheel.setDirection(DcMotor.Direction.REVERSE);
        lbWheel.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        /* Wait for the game to start (driver presses PLAY) waitForStart(); */


        lfWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rfWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lbWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rbWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        lIntake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rIntake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        Toggle intakeIn = new Toggle();
        Toggle intakeOut = new Toggle();


        final double forwards = 1.0;
        final double backwards = -1.0;

        Toggle slowMove = new Toggle();
        double speedMultiplier = 1.0;
        //boolean intakeIn = false, intakeOut = false; //controls direction of rotation of the intake motors - In to suck stones in, Out to spit them out


        waitForStart();
        while(opModeIsActive())
        {

            slowMove.update(gamepad1.a);
            if(slowMove.getState())
            {
                speedMultiplier = 0.5;
            }
            else
            {
                speedMultiplier = 1.0;
            }

            boolean leftStrafe = this.gamepad1.dpad_left;
            boolean rightStrafe = this.gamepad1.dpad_right;
            boolean backStrafe = this.gamepad1.dpad_down;
            boolean frontStrafe = this.gamepad1.dpad_up;


            speedMultiplier = Range.clip(speedMultiplier, 0.0, 1.0);
            if(leftStrafe)
            {
                lfWheel.setPower(backwards *speedMultiplier);
                rfWheel.setPower(forwards *speedMultiplier);
                lbWheel.setPower(forwards *speedMultiplier);
                rbWheel.setPower(backwards *speedMultiplier);
            }
            else if(rightStrafe)
            {
                lfWheel.setPower(forwards *speedMultiplier);
                rfWheel.setPower(backwards *speedMultiplier);
                lbWheel.setPower(backwards *speedMultiplier);
                rbWheel.setPower(forwards *speedMultiplier);
            }
            else if(backStrafe)
            {
                lfWheel.setPower(backwards *speedMultiplier);
                rfWheel.setPower(backwards *speedMultiplier);
                lbWheel.setPower(backwards *speedMultiplier);
                rbWheel.setPower(backwards *speedMultiplier);
            }
            else if(frontStrafe)
            {
                lfWheel.setPower(forwards *speedMultiplier);
                rfWheel.setPower(forwards *speedMultiplier);
                lbWheel.setPower(forwards *speedMultiplier);
                rbWheel.setPower(forwards *speedMultiplier);
            }

            else
            {
                double x = this.gamepad1.left_stick_x;
                double y = -this.gamepad1.left_stick_y;
                double turn = this.gamepad1.right_stick_x;

                double lfPower = y + x + turn;
                double rfPower = y - x - turn;
                double lbPower = y - x + turn;
                double rbPower = y + x - turn;

                lfWheel.setPower(Range.clip(lfPower *speedMultiplier, -1., 1.));
                rfWheel.setPower(Range.clip(rfPower *speedMultiplier, -1., 1.));
                lbWheel.setPower(Range.clip(lbPower *speedMultiplier, -1., 1.));
                rbWheel.setPower(Range.clip(rbPower *speedMultiplier, -1., 1.));
            }


            if(intakeIn.update(gamepad1.left_bumper)) { intakeOut.reset(); }
            if(intakeOut.update(gamepad1.right_bumper)) { intakeIn.reset(); }

            if(intakeIn.getState())
            {
                lIntake.setPower(-1);
                rIntake.setPower(1);
            }
            else if(intakeOut.getState())
            {
                lIntake.setPower(1);
                rIntake.setPower(-1);
            }
            else
            {
                lIntake.setPower(0);
                rIntake.setPower(0);
            }

        }
    }
}
