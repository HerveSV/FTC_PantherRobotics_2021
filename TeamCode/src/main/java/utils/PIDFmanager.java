package utils;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

/**
 * Abstract class for setting motor pidf values in the motor controller
 */
public abstract class PIDFmanager {

    private final static double maxVel = 4480;
    private final static double F = 32767/maxVel;//  32767 / maxVelocity of motor
    private final static double P = 0.1 * F;
    private final static double D = 0.0; //DO NOT CHANGE
    private final static double I = 0.1 * P;
    private final static double position = 5.0; //DO NOT CHANGE
    private final static PIDFCoefficients pidf = new PIDFCoefficients(P, I, D, F);

    public static void setPIDF(DcMotorEx ex)
    {
        ex.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidf);
        ex.setVelocityPIDFCoefficients(P, I, D, F);
        ex.setPositionPIDFCoefficients(position);
    }

    public static void setPIDF(DcMotor mtr)
    {
        DcMotorEx ex = (DcMotorEx)mtr;
        setPIDF(ex);
    }

    public static double getP() { return P; }
    public static double getI() { return I; }
    public static double getD() { return D; }
    public static double getF() { return F; }
    public static PIDFCoefficients getPIDF() { return pidf; }

}
