package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Gavin on 11/10/2015.
 */
public class CRABTANK extends OpMode {
    DcMotor LF;
    DcMotor RF;
    DcMotor LB;
    DcMotor RB;

    @Override
    public void init() {
        //note to have talk about productivity
        LF = hardwareMap.dcMotor.get("LF");
        RF = hardwareMap.dcMotor.get("RF");
        LB = hardwareMap.dcMotor.get("LB");
        RB = hardwareMap.dcMotor.get("RB");

        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.FORWARD);
        LB.setDirection(DcMotor.Direction.FORWARD);
        RB.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {
        float leftY = -gamepad1.left_stick_y;//values of gamepad joysticks
        float rightY = -gamepad1.right_stick_y;

        RF.setPower(rightY);
        RB.setPower(rightY);
        LF.setPower(-leftY);
        LB.setPower(-leftY);

    }


}
