package org.firstinspires.ftc.teamA;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@TeleOp

public class intakeTest extends LinearOpMode
{
    private DcMotor leftIntake, rightIntake;

    @Override
    public void runOpMode()
    {
        leftIntake = hardwareMap.get(DcMotor.class, "lIntake");
        rightIntake = hardwareMap.get(DcMotor.class, "rIntake");

        waitForStart();
        while(opModeIsActive())
        {
            double pwr = -this.gamepad1.left_stick_y;

            leftIntake.setPower(pwr);
            rightIntake.setPower(-pwr);


            telemetry.addData("Intake power", "Left %f, Right %f", leftIntake.getPower(), rightIntake.getPower());
            telemetry.update();
        }

    }
}