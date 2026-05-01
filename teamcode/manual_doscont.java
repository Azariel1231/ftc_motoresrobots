package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class manual_doscont extends LinearOpMode{
    //definir variables
    DcMotor motorD;
    DcMotor motorI;
    DcMotor indexer;
    DcMotorEx Expulsador;
    Servo servo0;



    @Override
    public void runOpMode(){

        String classOrinterface;
        motorD = hardwareMap.get(DcMotor.class,"motor-D");
        motorI = hardwareMap.get(DcMotor.class,"motor-I");
        motorI.setDirection(DcMotorSimple.Direction.REVERSE);

        indexer = hardwareMap.get(DcMotor.class,"indexer");
        indexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        indexer.setDirection(DcMotorSimple.Direction.REVERSE);

        Expulsador = hardwareMap.get(DcMotorEx.class,"Expulsador");
        Expulsador.setDirection(DcMotorSimple.Direction.REVERSE);
        Expulsador.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);

        servo0 = hardwareMap.get(Servo.class,"servo0");
        servo0.setPosition(0);

        waitForStart();

        while(opModeIsActive()){
            motorD.setPower(gamepad1.right_stick_y*1);
            motorI.setPower(gamepad1.left_stick_y*1);
        if (gamepad2.b) {
                servo0.setPosition(1);
            } else{
                servo0.setPosition(0);
            }
        if(gamepad2.a) {
                indexer.setPower(1);
            }else {
                indexer.setPower(0);
            }
            if(gamepad1.b){
                Expulsador.setVelocity(800);
            } else {
                Expulsador.setVelocity(0);
            }

        }
        }
    }
