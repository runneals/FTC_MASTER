package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Gavin on 11/5/2015.
 */
public class CRAB extends OpMode {
    DcMotor Dump;
    DcMotor Lift;
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
        Lift = hardwareMap.dcMotor.get("LIFT");
        Dump = hardwareMap.dcMotor.get("dumper");


        LF.setDirection(DcMotor.Direction.FORWARD);
        RF.setDirection(DcMotor.Direction.FORWARD);
        LB.setDirection(DcMotor.Direction.FORWARD);
        RB.setDirection(DcMotor.Direction.FORWARD);
    }

    @Override
    public void loop() {

        //magic
        //do not touch

        if (gamepad1.dpad_up) {     //if the dpads up is true or pressed then run the code inside the { } brackets
            LF.setPower(0.5);
            RF.setPower(-0.5);
            LB.setPower(0.5);
            RB.setPower(-0.5);
        }
        else if(gamepad1.dpad_down){       //if thats not true then is this true?
            LF.setPower(-0.5);
            RF.setPower(0.5);
            LB.setPower(-0.5);
            RB.setPower(0.5);
        }
        else if(gamepad1.dpad_right){
            LF.setPower(0.5);
            RF.setPower(0.5);
            LB.setPower(-0.5);
            RB.setPower(-0.5);
        }
        else if(gamepad1.dpad_left){
            LF.setPower(-0.5);
            RF.setPower(-0.5);
            LB.setPower(0.5);
            RB.setPower(0.5);
        }
        else if(gamepad1.left_bumper){          //bumpers are the buttons... NOT THE TRIGGERS
            LF.setPower(-0.5);
            RF.setPower(-0.5);
            LB.setPower(-0.5);
            RB.setPower(-0.5);
        }
        else if(gamepad1.right_bumper){
            LF.setPower(0.5);
            RF.setPower(0.5);
            LB.setPower(0.5);
            RB.setPower(0.5);
        }
        else{                   //if nothing is true than do this
            LF.setPower(0.0);
            RF.setPower(0.0);
            LB.setPower(0.0);
            RB.setPower(0.0);
        }
        float leftY = -gamepad2.left_stick_y;//sets the value of the float named leftY equal to the value of negative gamepad1 left stick's Y value
        float rightY = -gamepad2.right_stick_y;//a float is a small data type that contains a number with a decimal point like 1.1

        Dump.setPower(leftY);//sets the power of the motor named right to the value of the float leftY
        Lift.setPower(rightY);
    }
}