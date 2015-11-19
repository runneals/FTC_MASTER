package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by FTC-7491 on 11/17/2015.
 */
public class InfiniteTankDrive extends OpMode {

    DcMotor Right;
    DcMotor Left;

    @Override
    public void init() {

        Right = hardwareMap.dcMotor.get ("left_drive");
        Left = hardwareMap.dcMotor.get ("right_drive");

        Left.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        Right.setPower(.5);
        Left.setPower(.5);

    }
}
