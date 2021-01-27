//
// code
// make move robot
//
// noobmaster69
// 2021
//

package org.firstinspires.ftc.teamB;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp
public class TeleOpMecanumV69420 extends LinearOpMode {
    private DcMotor wheel_lf, wheel_rf, wheel_lb, wheel_rb;
    private Servo wing_l, wing_r;

    @Override
    public void runOpMode() {
        // wheel setup
        wheel_lf = hardwareMap.get(DcMotor.class, "lf");
        wheel_rf = hardwareMap.get(DcMotor.class, "rf");
        wheel_lb = hardwareMap.get(DcMotor.class, "lb");
        wheel_rb = hardwareMap.get(DcMotor.class, "rb");

        wheel_lf.setDirection(DcMotor.Direction.REVERSE);
        wheel_lb.setDirection(DcMotor.Direction.REVERSE);

        // servo setup
        wing_l = hardwareMap.get(Servo.class, "lw");
        wing_l = hardwareMap.get(Servo.class, "rw");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        wheel_lf.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        wheel_rf.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        wheel_lb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        wheel_rb.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        boolean chicken = false;
        boolean chicken_pressed = false;
        final double forwards = 1.0;
        final double backwards = -1.0;
        double speedMultiplier;

        waitForStart();

        while (opModeIsActive()) {
            speedMultiplier = (gamepad1.a)? 0.5 : 1.0;

            boolean leftStrafe = this.gamepad1.dpad_left;
            boolean rightStrafe = this.gamepad1.dpad_right;
            boolean backStrafe = this.gamepad1.dpad_up;
            boolean frontStrafe = this.gamepad1.dpad_down;

            if (leftStrafe) {
                wheel_lf.setPower(backwards * speedMultiplier);
                wheel_rf.setPower(forwards * speedMultiplier);
                wheel_lb.setPower(forwards * speedMultiplier);
                wheel_rb.setPower(backwards * speedMultiplier);
            } else if (rightStrafe) {
                wheel_lf.setPower(forwards * speedMultiplier);
                wheel_rf.setPower(backwards * speedMultiplier);
                wheel_lb.setPower(backwards * speedMultiplier);
                wheel_rb.setPower(forwards * speedMultiplier);
            } else if (backStrafe) {
                wheel_lf.setPower(backwards * speedMultiplier);
                wheel_rf.setPower(backwards * speedMultiplier);
                wheel_lb.setPower(backwards * speedMultiplier);
                wheel_rb.setPower(backwards * speedMultiplier);
            } else if (frontStrafe) {
                wheel_lf.setPower(forwards * speedMultiplier);
                wheel_rf.setPower(forwards * speedMultiplier);
                wheel_lb.setPower(forwards * speedMultiplier);
                wheel_rb.setPower(forwards * speedMultiplier);
            } else {
                double x = this.gamepad1.left_stick_x;
                double y = -this.gamepad1.left_stick_y;
                double turn = this.gamepad1.left_stick_x;

                double lfPower = y + x + turn;
                double rfPower = y - x - turn;
                double lbPower = y - x + turn;
                double rbPower = y + x - turn;

                wheel_lf.setPower(Range.clip(lfPower * speedMultiplier, -1., 1.));
                wheel_rf.setPower(Range.clip(rfPower * speedMultiplier, -1., 1.));
                wheel_lb.setPower(Range.clip(lbPower * speedMultiplier, -1., 1.));
                wheel_rb.setPower(Range.clip(rbPower * speedMultiplier, -1., 1.));
            }
        }
    }
}
