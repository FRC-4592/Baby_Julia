package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Lib.SubsystemFramework;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;
import frc.robot.Hardware;

public class Drivetrain extends SubsystemFramework {
    //Hardware

    private DifferentialDrive myRobot;
	private WPI_VictorSPX rightMasterMotor;
	private WPI_VictorSPX leftMasterMotor;
	private WPI_VictorSPX rightSlaveMotor;
	private WPI_VictorSPX leftSlaveMotor;


	public Drivetrain(WPI_VictorSPX rightMasterMotor, WPI_VictorSPX rightSlaveMotor,
			WPI_VictorSPX leftMasterMotor, WPI_VictorSPX leftSlaveMotor) {
	

		// Setup Drivetrain
		myRobot = new DifferentialDrive(rightMasterMotor, leftMasterMotor);

		// Motor Controllers
		this.rightMasterMotor = rightMasterMotor;
		this.rightSlaveMotor = rightSlaveMotor;
		this.leftMasterMotor = leftMasterMotor;
		this.leftSlaveMotor = leftSlaveMotor;
	}


	@Override
	public void update() {

		/*if (Hardware.driverPad.getRawAxis(1) < 0.1 && Hardware.driverPad.getRawAxis(1) > -0.1){
			myRobot.arcadeDrive(0,(Hardware.driverPad.getRawAxis(4) * -1) );
		}
		if (Hardware.driverPad.getRawAxis(4) < 0.1 && Hardware.driverPad.getRawAxis(4) > -0.1){
			myRobot.arcadeDrive((Hardware.driverPad.getRawAxis(1) * -1), 0);
		}*/

        
        	// Setup Master Slave Relationship
		//rightSlaveMotor.follow(rightMasterMotor);
		//leftSlaveMotor.follow(leftMasterMotor);
	

		myRobot.arcadeDrive((Hardware.driverPad.getRawAxis(1)), (Hardware.driverPad.getRawAxis(4) * -1), false);

	}

	@Override
	public void outputToSmartDashboard() {

	}
	
	@Override
	public void setupSensors() {		
				// Setup Master Slave Relationship
				rightSlaveMotor.follow(rightMasterMotor);
				leftSlaveMotor.follow(leftMasterMotor);
                rightSlaveMotor.setInverted(true);
                leftSlaveMotor.setInverted(true);
						
				// Setup Master Encoders
				rightMasterMotor.setSensorPhase(true);
				leftMasterMotor.setSensorPhase(true);
						
				rightMasterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
				leftMasterMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		
				rightMasterMotor.setSelectedSensorPosition(0, 0, 10);
				leftMasterMotor.setSelectedSensorPosition(0, 0, 10);
				
				rightMasterMotor.configNominalOutputForward(0, 10);
				leftMasterMotor.configNominalOutputForward(0, 10);
				rightMasterMotor.configNominalOutputReverse(0, 10);
				leftMasterMotor.configNominalOutputReverse(0, 10);
				rightMasterMotor.configPeakOutputForward(.3, 10);
				leftMasterMotor.configPeakOutputForward(1, 10);
				rightMasterMotor.configPeakOutputReverse(-.3, 10);
				leftMasterMotor.configPeakOutputReverse(-1, 10);
    }
}