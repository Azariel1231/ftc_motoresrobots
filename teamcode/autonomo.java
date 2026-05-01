package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.sql.Driver;

@Autonomous
public class autonomo extends LinearOpMode{
    //definir variables
    DcMotor motorD;
    DcMotor motorI;
    DcMotor indexer;
    DcMotor Expulsador;
    Servo servo0;

    @Override
    public void runOpMode(){

        String classOrinterface;
        motorD = hardwareMap.get(DcMotor.class,"motor-D");
        motorI = hardwareMap.get(DcMotor.class,"motor-I");
        //llantaB.setDirection(DcMotorSimple.Direction.REVERSE);

        indexer = hardwareMap.get(DcMotor.class,"indexer");
        Expulsador = hardwareMap.get(DcMotor.class,"Expulsador");
        Expulsador.setDirection(DcMotorSimple.Direction.REVERSE);
        Expulsador.setPower(0);
        servo0 = hardwareMap.get(Servo.class,"servo0");
        servo0.setPosition(0);
        indexer.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        indexer.setDirection(DcMotorSimple.Direction.REVERSE);
        ElapsedTime temporizador = new ElapsedTime();

        waitForStart();
        temporizador.reset();
        while(temporizador.seconds()<3) {
            servo0.setPosition(1);
        }
        servo0.setPosition(0);
        while(temporizador.seconds()<5){
            indexer.setPower(0.8);
            Expulsador.setPower(1);
        }
        indexer.setPower(0);
        while(temporizador.seconds()<6){
            Expulsador.setPower(1);
        }
        temporizador.reset();
        while(temporizador.seconds()<5){
            motorD.setPower(0.9);
            motorI.setPower(0.9);
        }
        motorD.setPower(0);
        motorI.setPower(0);

    }
}

