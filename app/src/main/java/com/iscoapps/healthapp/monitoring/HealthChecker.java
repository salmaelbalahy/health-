package com.iscoapps.healthapp.monitoring;

public class HealthChecker {
    private static int minHeartRate = 60;
    private static int maxHeartRate = 70; //TODO: Change to 100
    private static int minSystolicBP = 90;
    private static int maxSystolicBP = 140;
    private static int minDiastolicBP = 60;
    private static int maxDiastolicBP = 90;
    private static int minOxygenSaturation = 90;

    public static int getMinHeartRate() {
        return minHeartRate;
    }

    public static void setMinHeartRate(int minHeartRate) {
        HealthChecker.minHeartRate = minHeartRate;
    }

    public static int getMaxHeartRate() {
        return maxHeartRate;
    }

    public static void setMaxHeartRate(int maxHeartRate) {
        HealthChecker.maxHeartRate = maxHeartRate;
    }

    public static int getMinSystolicBP() {
        return minSystolicBP;
    }

    public static void setMinSystolicBP(int minSystolicBP) {
        HealthChecker.minSystolicBP = minSystolicBP;
    }

    public static int getMaxSystolicBP() {
        return maxSystolicBP;
    }

    public static void setMaxSystolicBP(int maxSystolicBP) {
        HealthChecker.maxSystolicBP = maxSystolicBP;
    }

    public static int getMinDiastolicBP() {
        return minDiastolicBP;
    }

    public static void setMinDiastolicBP(int minDiastolicBP) {
        HealthChecker.minDiastolicBP = minDiastolicBP;
    }

    public static int getMaxDiastolicBP() {
        return maxDiastolicBP;
    }

    public static void setMaxDiastolicBP(int maxDiastolicBP) {
        HealthChecker.maxDiastolicBP = maxDiastolicBP;
    }

    public static int getMinOxygenSaturation() {
        return minOxygenSaturation;
    }

    public static void setMinOxygenSaturation(int minOxygenSaturation) {
        HealthChecker.minOxygenSaturation = minOxygenSaturation;
    }

    public static boolean isHeartRateNormal(int heartRate) {
        return heartRate > minHeartRate && heartRate < maxHeartRate;
    }

    public static boolean isBloodPressureNormal(int systolicBP, int diastolicBP) {
        return systolicBP > minSystolicBP && systolicBP < maxSystolicBP &&
                diastolicBP > minDiastolicBP && diastolicBP < maxDiastolicBP;
    }

    public static boolean isOxygenSaturationNormal(int oxygenSaturation) {
        return oxygenSaturation > minOxygenSaturation;
    }
}
