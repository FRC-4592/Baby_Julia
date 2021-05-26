package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;


public class Hardware {
    // Drivetrain Motors
    public static final WPI_VictorSPX rightMasterMotor = new WPI_VictorSPX(Constants.RIGHT_MASTER_MOTOR);
    public static final WPI_VictorSPX leftMasterMotor = new WPI_VictorSPX(Constants.LEFT_MASTER_MOTOR);
    public static final WPI_VictorSPX rightSlaveMotor = new WPI_VictorSPX(Constants.RIGHT_SLAVE_MOTOR);
    public static final WPI_VictorSPX leftSlaveMotor = new WPI_VictorSPX(Constants.LEFT_SLAVE_MOTOR);

    // Shooter Motors
    public static final VictorSP reloadMotor = new VictorSP(Constants.RELOAD_MOTOR);
    public static final VictorSP turretMotor = new VictorSP(Constants.TURRET_MOTOR);
    public static final VictorSP shootMotor = new VictorSP(Constants.SHOOT_MOTOR);

    // Joystick
    public static final Joystick driverPad = new Joystick(Constants.DRIVE_USB_PORT);
}
