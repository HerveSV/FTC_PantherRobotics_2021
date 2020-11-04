package org.firstinspires.ftc.teamA;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import utils.PIDFmanager;


@Autonomous

public class encoderTest extends LinearOpMode
{

    private static final double COUNTS_PER_MOTOR_REV = 1478.4;    // Number of ticks for every full revolution/rotation of the motor shaft - this is specific to our model of motors
    private static final double DRIVE_GEAR_REDUCTION = 1.0;     // Depends on gearing ratio between motor and wheel
    private static final double WHEEL_DIAMETER_MM = 78.0;     // For figuring circumference
    private static final double COUNTS_PER_MM = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_MM * 3.1415);  //This is the amount of ticks we have every mm travelled by the wheel


    private final static double maxVel = 4480;
    private final static double F = 32767/maxVel;//32767 / maxVelocity of motor
    private final static double P = 0.1 * F;
    private final static double D = 0.0; //DO NOT CHANGE
    private final static double I = 0.1 * P;
    private final static double position = 5.0; //DO NOT CHANGE
    private final static PIDFCoefficients pidf = new PIDFCoefficients(P, I, D, F);

    private DcMotor motor;

    @Override
    public void runOpMode()
    {

        motor = hardwareMap.get(DcMotor.class, "testMotor");


        //
        PIDFmanager.setPIDF(motor);
        //DcMotorEx ex =(DcMotorEx) motor;
        //ex.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidf);

        waitForStart();

        int target = motor.getCurrentPosition() + ((int) COUNTS_PER_MOTOR_REV);
        motor.setTargetPosition(target);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);



        motor.setPower(1);
        while(opModeIsActive() && motor.isBusy())
        {

            telemetry.addData("Target pos", motor.getTargetPosition());
            telemetry.addData("Curr pos", motor.getCurrentPosition());
            telemetry.update();
        }
        motor.setPower(0);




    }
}