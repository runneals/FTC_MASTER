package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Gavin on 10/3/2015.
 */
public class TankdriveAuto extends OpMode {

    DcMotor P1;
    DcMotor P2;
    int X;

    @Override
    public void init() {
        P1 = hardwareMap.dcMotor.get("left_drive");
        P2 = hardwareMap.dcMotor.get("right_drive");
        X = 0;

        P2.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {



        if (X == 0){
            P1.setPower(1);
            P2.setPower(1);
            try {
                wait(1000);
            } catch (InterruptedException e) {
            }
            X = 1;
        } else if(X == 1){
            P1.setPower(0);
            P2.setPower(0);
        }

        }
    }
