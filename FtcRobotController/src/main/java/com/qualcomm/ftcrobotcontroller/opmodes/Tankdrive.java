package com.qualcomm.ftcrobotcontroller.opmodes;
//this will be created for you upon creation of the class file

//always remember to register your OpModes in the FtcOpModeRegister file!

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
//bunch of imports created automatically by the program
//basically just allows the program to use methods from other classes

public class Tankdrive extends OpMode {//public class ClassNamehere extends OpMode is a requirement of any robot code for ftc
                                        //basically defines the class and tells it to inherit the methods of the OpMode class
                                          //classes are java files

    DcMotor Right;//defines motor objects
    DcMotor Left;//basically tells the code there will be DCmotors with the names Right and Left

    @Override
    public void init()//the init method runs one time when the code starts
    {
        Right = hardwareMap.dcMotor.get("left_drive");//sets the values of the motors in the code to the motors in the phone's hardware map
        Left = hardwareMap.dcMotor.get("right_drive");//the hardware map is created on the phone
                                                        //the line hardwareMap.dcMotor.get("right_drive"); tells it to find a DCmotor named right_drive on the hardware map

        Left.setDirection(DcMotor.Direction.REVERSE);//reverses the motor named Left
    }

    @Override
    public void loop()//this loop method runs over and over again as long as the code is running
    {

        float leftY = -gamepad1.left_stick_y;//sets the value of the float named leftY equal to the value of negative gamepad1 left stick's Y value
        float rightY = -gamepad1.right_stick_y;//a float is a small data type that contains a number with a decimal point like 1.1

        Right.setPower(leftY);//sets the power of the motor named right to the value of the float leftY
        Left.setPower(rightY);//yes, I know I'm setting the right motor to the value meant for the left motor

    }
}
