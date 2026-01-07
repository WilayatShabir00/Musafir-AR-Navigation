package com.codingwithvedang.musafir.indoorLocation;

public interface WifiNotificationListener {
    void onServerSendsFix(double lat, double lng, double alt);
}
