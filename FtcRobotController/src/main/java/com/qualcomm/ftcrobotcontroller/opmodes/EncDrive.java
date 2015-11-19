package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

public class EncDrive extends OpMode {

    //magic do not remove
    DcMotor Left;
    DcMotor Right;
    //end magic
    int inches = 12;        //these are variables they store stuffs
    int counts = 93*inches; //Int is a solid number/counting number ex. 1.. 2.. 3.. 4..
                              //int nameofvariable = value of it

    @Override
    public void init() {
        Left = hardwareMap.dcMotor.get("left_drive");
        Right = hardwareMap.dcMotor.get("right_drive");
        Right.setDirection(DcMotor.Direction.REVERSE);//reverses one of the motors

        Right.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS); //resets the encoder on the right wheel
        Left.setChannelMode(DcMotorController.RunMode.RESET_ENCODERS);  //same but for the left
    }

    @Override
    public void loop() {//notice loop is empty

    }

    public void start() {//start method runs once after the init already ran
        Left.setTargetPosition(counts); //sets the encoders target position to that value of the variable counts
        Right.setTargetPosition(counts);

        Left.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);//sets the mode to run to position
        Right.setChannelMode(DcMotorController.RunMode.RUN_TO_POSITION);//basicly tells it to stop it when the target position hits where it is supposed to be

        Left.setPower(0.5);//sets the motors to go with a power of 0.5
        Right.setPower(0.5);
    }
}
