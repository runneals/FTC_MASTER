package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by Gavin on 10/29/2015.
 */
public class LinearTest extends LinearOpMode {

    DcMotor Left;
    DcMotor Right;

    int inches = 12;
    int counts = 93*inches;
    int Turn = 2000;

    @Override
    public void runOpMode() throws InterruptedException {
        Left = hardwareMap.dcMotor.get("left_drive");
        Right = hardwareMap.dcMotor.get("right_drive");//reversed

        Right.setDirection(DcMotor.Direction.REVERSE);

        Right.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        Left.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

        waitForStart();

        Left.setTargetPosition(counts);
        Right.setTargetPosition(counts);

        Left.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        Right.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        Left.setPower(0.5);
        Right.setPower(0.5);

        sleep(2000);
        Right.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        Left.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        sleep(20);

        Left.setTargetPosition(-Turn);
        Right.setTargetPosition(Turn);

        Left.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        Right.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        Left.setPower(-0.5);
        Right.setPower(0.5);


    }
}
