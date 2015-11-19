package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Gavin on 10/22/2015.
 */
public class Drive extends OpMode {

    DcMotor Left;
    DcMotor Right;
    ElapsedTime Time;

    static final float forwardTime = 1.0f;
    static final float turnTime = 1.0f;
    int count = 0;

    enum State {drivingStraight, turning, done}
    State state;



    @Override
    public void init() {
        Left = hardwareMap.dcMotor.get("left_drive");
        Right = hardwareMap.dcMotor.get("right_drive");
        Right.setDirection(DcMotor.Direction.REVERSE);//reverses one of the motors

        Time = new ElapsedTime();
        state = State.drivingStraight;
    }

    @Override
    public void loop() {
        double currentTime = Time.time();
        switch(state) {
            case drivingStraight:
                Left.setPower(0.5);
                Right.setPower(0.5);
                if (currentTime > forwardTime) {
                    state = State.turning;
                    Time.reset();
                }
                break;
            case turning:
                Left.setPower(0.5);
                Right.setPower(-0.5);
                if (currentTime > turnTime) {
                    state = state.drivingStraight;
                    Time.reset();
                }
                break;
        }

    }
}
