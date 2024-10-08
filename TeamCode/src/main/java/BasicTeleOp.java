package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name="BasicTeleOp", group="TeleOp")
public class BasicTeleOp extends OpMode {

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
    }
}