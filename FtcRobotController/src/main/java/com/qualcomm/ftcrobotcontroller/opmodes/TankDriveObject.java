package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Gavin on 10/24/2015.
 */
public class TankDriveObject {

    private DcMotor Right;
    private DcMotor Left;
    float leftspeed = 0;
    float rightspeed = 0;
    public TankDriveObject(DcMotor left,DcMotor right ){
        Right = right;
        Left = left;

        right.setDirection(DcMotor.Direction.REVERSE);
    }

    public void update(float leftstick, float rightstick)
    {
      leftspeed = leftstick;
      rightspeed = rightstick;
      Right.setPower(rightspeed);
      Left.setPower(leftspeed);
    }

}
