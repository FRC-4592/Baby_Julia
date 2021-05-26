package frc.robot.Subsystems;

import frc.robot.Constants;
import frc.robot.Hardware;
import frc.robot.Lib.SubsystemFramework;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Turret extends SubsystemFramework {
    // Turret Motors
    private VictorSP reloadMotor;
    private VictorSP turretMotor;
    private VictorSP shootMotor;

    public Turret(VictorSP reloadMotor, VictorSP turretMotor, VictorSP shootMotor) {
        this.reloadMotor = reloadMotor;
        this.turretMotor = turretMotor;
        this.shootMotor = shootMotor;
    }
    public static boolean Shoot() {
        return Hardware.driverPad.getRawAxis(3) > 0; 
    }
    public static boolean SpinTurret() {
        return Hardware.driverPad.getRawButton(5);
    }
    public static boolean ReverseSpin() {
        return Hardware.driverPad.getRawButton(6);
    }

    @Override
    public void update() {
        if(Shoot()) {
            shootMotor.set(-1);
            reloadMotor.set(-0.7);
        }
        else {
            shootMotor.set(0);
            reloadMotor.set(0);
        }
        if(SpinTurret()) {
            turretMotor.set(-0.7);
        }
        else {
            turretMotor.set(0);
        }
        if(ReverseSpin()) {
            turretMotor.set(0.7);
        }
        else {
            turretMotor.set(0);
        }
        outputToSmartDashboard();
    }

    @Override
    public void outputToSmartDashboard() {

    }

    @Override
    public void setupSensors() {

    }
}