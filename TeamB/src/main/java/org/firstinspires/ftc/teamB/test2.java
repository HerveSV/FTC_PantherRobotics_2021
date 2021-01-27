//
// test2
// test stuff
//
// noobmaster69
// 2021
//

// beginning of code

// package name
package org.firstinspires.ftc.teamB;

// import statements
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

// main class
@TeleOp
public class test2 extends LinearOpMode { // opening curly bracket
    // override OpMode
    @Override
    public void runOpMode() { // opening curly bracket
        // wait for start
        waitForStart();

        // while opModeIsActive() is true, repeat
        while (opModeIsActive()) { // opening curly bracket
            telemetry.addLine("Yeeet2");
            telemetry.update();
        } // closing curly bracket ( while (opModeIsActive()) { )
    } // closing curly bracket ( public void runOpMode() { )
} // closing curly bracket ( public class test2 extends LinearOpMode { )

// end of code
