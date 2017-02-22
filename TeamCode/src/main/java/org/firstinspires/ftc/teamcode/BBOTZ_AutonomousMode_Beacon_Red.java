package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Autonomous Beacon Red", group="Autonomous mode")
// @Disabled
public class BBOTZ_AutonomousMode_Beacon_Red extends LinearOpMode {

    BBOTZ_AutonomousMode_Common_Methods autonomousModeCommonMethods;

    /* Declare OpMode members. */
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        autonomousModeCommonMethods = new BBOTZ_AutonomousMode_Common_Methods(hardwareMap);

        // reset encoder
        autonomousModeCommonMethods.resetEncoder();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // Launch ball
        autonomousModeCommonMethods.launchBall();

        // Advance forward to avoid hitting back wall
        autonomousModeCommonMethods.driveForwardUsingTime(600);

        // Tankturn towards beacon #1 tape
        autonomousModeCommonMethods.tankTurnLeft(580);

        // Drive fast towards beacon #1 tape
        autonomousModeCommonMethods.driveForwardUsingTimeBeacon(1500);

        // Search for beacon #1 tape using ODS sensor
        autonomousModeCommonMethods.driveForwardUsingODS();

        // Drive back a little to correct overshoot
        autonomousModeCommonMethods.driveBackwardUsingTime(200);

        // Tankturn to have back face beacon #1
        autonomousModeCommonMethods.tankTurnRightSlow(1500);

        // After tankturn, is the sensor still on beacon #1 tape?
        // if not, adjust here

        // Assuming the tape is found ... continue

        // Follow tape to beacon #1, going backwards
        // autonomousModeCommonMethods.followTapeUsingODS(telemetry);

        // Move forward to read beacon #1 color
        // autonomousModeCommonMethods.driveForwardUsingTime(800);

        // Change beacon #1 color
        autonomousModeCommonMethods.pressBeaconForColor(BBOTZ_AutonomousMode_Common_Methods.BEACON_RED);

        // Start moving to next beacon

        // Tankturn to beacon #2 tape (slightly away from wall)
        autonomousModeCommonMethods.tankTurnLeft(1100);

        // Drive forward so that same tape is not detected
        autonomousModeCommonMethods.driveForwardUsingTime(800);

        // Search for beacon #2 tape using ODS sensor
        autonomousModeCommonMethods.driveForwardUsingODS();

        // Drive back a little to correct overshoot
        autonomousModeCommonMethods.driveBackwardUsingTime(200);

        // Tankturn to have back face beacon #2
        autonomousModeCommonMethods.tankTurnRightSlow(1050);

        // Follow tape to beacon #2, going backwards
        // autonomousModeCommonMethods.followTapeUsingODS();

        // Move forward to get beacon #2 color
        // autonomousModeCommonMethods.driveForwardUsingTime(800);

        // Change beacon #2 color
        autonomousModeCommonMethods.pressBeaconForColor(BBOTZ_AutonomousMode_Common_Methods.BEACON_RED);

        // Tankturn right to face cap ball
        autonomousModeCommonMethods.tankTurnRightSlow(650);

        // Advance 20" to knock off big ball, then stop
        autonomousModeCommonMethods.sprintForwardUsingTime(1600);

        // Park on center ramp
        // autonomousModeCommonMethods.turnLeft(800);

    }
}
