package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Gavin on 10/13/2015.
 */
public class TestBot extends OpMode {
    DcMotor left;
    DcMotor Right;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("Left");
        Right = hardwareMap.dcMotor.get("Right");

        Right.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {
        float rightY = -gamepad1.right_stick_y;
        float leftY = -gamepad1.left_stick_y;

        left.setPower(leftY);
        Right.setPower(rightY);

    }
}