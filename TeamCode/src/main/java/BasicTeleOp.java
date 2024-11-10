//package org.firstinspires.ftc.teamcode;

//basic teleop mode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="BasicTeleOp", group="TeleOp")
public class BasicTeleOp extends OpMode {

    private Servo armServo = null;
    private Servo intakeServo = null;

    // Declare motor variables for the robot's four motors
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;

    // runs once when the OpMode starts
    @Override
    public void init() {

        // Map the motors to their configuration names in the Control Hub
        frontLeft = hardwareMap.get(DcMotor.class,"frontLeft");
        frontRight = hardwareMap.get(DcMotor.class,"frontRight");
        backLeft = hardwareMap.get(DcMotor.class,"backLeft");
        backRight = hardwareMap.get(DcMotor.class,"backRight");

        //Servos
        armServo = hardwareMap.get(Servo.class, "armServo");
        intakeServo = hardwareMap.get(Servo.class, "intakeServo");

        // Set the right-side motors to reverse direction
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {

        // Set power to the right motors based on the right joystick (negative for correct orientation)
        backRight.setPower(-gamepad1.right_stick_y);
        frontRight.setPower(-gamepad1.right_stick_y);

        // Set power to the left motors based on the left joystick (negative for correct orientation)
        backLeft.setPower(-gamepad1.left_stick_y);
        frontLeft.setPower(-gamepad1.left_stick_y);

        //servo motor
        if (gamepad1.a) {
            armServo.setPosition(1.0); // Fully open the servo
        } else if (gamepad1.b) {
            armServo.setPosition(0.0); // Fully closed the servo
        }
        if (gamepad1.x) {
            intakeServo.setPosition(1.0); // Fully open the servo
        } else if (gamepad1.y) {
            intakeServo.setPosition(0.0); // Fully closed the servo
        }
    }
}