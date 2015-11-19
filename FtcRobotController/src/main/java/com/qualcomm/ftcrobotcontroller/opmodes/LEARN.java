package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Gavin on 10/24/2015.
 */
public class LEARN extends OpMode {

    DcMotor P1;
    DcMotor P2;

    @Override
    public void init()
    {
        P1 = hardwareMap.dcMotor.get("left_drive");
        P2 = hardwareMap.dcMotor.get("right_drive");

        P2.setDirection(DcMotor.Direction.REVERSE);//reverses one of the motors
    }

    @Override
    public void loop()
    {
        float leftY = -gamepad1.left_stick_y;//values of gamepad joysticks
        float rightY = -gamepad1.right_stick_y;

        P1.setPower(leftY);//set values of motors to values of joysticks
        P2.setPower(rightY);
    }
}
