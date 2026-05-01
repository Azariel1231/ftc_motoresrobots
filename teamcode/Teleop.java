package org.firstinspires.ftc.teamcode;

import android.widget.AlphabetIndexer;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoControllerEx;

@TeleOp
public class Teleop extends LinearOpMode{
    //definir variables
    DcMotor motorD;
    DcMotor motorI;
    DcMotorEx indexer;
    DcMotorEx Expulsador;
    Servo servo0;

    @Override
    public void runOpMode(){

        String classOrinterface;
        motorD = hardwareMap.get(DcMotor.class,"motor-D");
        motorI = hardwareMap.get(DcMotor.class,"motor-I");
        motorI.setDirection(DcMotorSimple.Direction.REVERSE);

        indexer = hardwareMap.get(DcMotorEx.class,"indexer");
        indexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        indexer.setDirection(DcMotorSimple.Direction.REVERSE);

        Expulsador = hardwareMap.get(DcMotorEx.class,"Expulsador");
        Expulsador.setDirection(DcMotorSimple.Direction.REVERSE);

        servo0 = hardwareMap.get(Servo.class,"servo0");


        waitForStart();

        while(opModeIsActive()){
            motorD.setPower(gamepad1.right_stick_y*1);
            motorI.setPower(gamepad1.left_stick_y*1);
        if (gamepad1.y) {
                servo0.setPosition(0.8);
            } else{
                servo0.setPosition(0.4);
            }
        if(gamepad1.a) {
            indexer.setPower(1);
            }else {
                indexer.setPower(0);
            }
        if(gamepad1.b){
                Expulsador.setVelocity(800);
            } else {
                Expulsador.setVelocity(0);
            }
//        if(gamepad1.x){
//            indexer.setPower(1);
//            indexer.setDirection(DcMotorSimple.Direction.FORWARD);
//        }else{
//            indexer.setPower(0);
//        }

        }
        }
    }
