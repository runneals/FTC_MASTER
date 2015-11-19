package com.qualcomm.ftcrobotcontroller.opmodes;

import android.widget.Switch;

import com.qualcomm.robotcore.eventloop.EventLoopManager;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Gavin on 10/27/2015.
 */
public class EncTurn extends OpMode {

    DcMotor Left;
    DcMotor Right;
    ElapsedTime Time;

    int timecount = 0;
    int inches = 12;
    int counts = 93*inches;
    int turn_time = 50;
    int turn_counts = 0;
    enum State{Driving, Turning, Done};
    State ton;

    @Override
    public void init() {
        Left = hardwareMap.dcMotor.get("left_drive");
        Right = hardwareMap.dcMotor.get("right_drive");
        Right.setDirection(DcMotor.Direction.REVERSE);//reverses one of the motors

        Right.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        Left.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

        Time = new ElapsedTime();
        ton = State.Driving;

    }

    @Override
    public void loop() {
        double CurrentTime = Time.time();
        switch(ton) {
            case Driving:
                Left.setTargetPosition(counts);
                Right.setTargetPosition(counts);

                Left.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
                Right.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

                Left.setPower(0.5);
                Right.setPower(0.5);
                if (CurrentTime > turn_time)
                {
                    ton = State.Turning;
                }
                break;
            case Turning:
                Left.setTargetPosition(turn_counts);
                Right.setTargetPosition(-turn_counts);

                Left.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
                Right.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

                Left.setPower(0.5);
                Right.setPower(-0.5);

        }

    }

    public void start(){
        Left.setTargetPosition(counts);
        Right.setTargetPosition(counts);

        Left.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);
        Right.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);

        Left.setPower(0.5);
        Right.setPower(0.5);

        Left.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);
        Right.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);

        Left.setTargetPosition(turn_counts);
        Right.setTargetPosition(-turn_counts);

        Left.setPower(0.5);
        Right.setPower(-0.5);


    }
}
