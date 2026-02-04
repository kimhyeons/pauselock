package com.example.pauselock;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "phishing_logs")
public class PhishingEvent {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public long timestamp;      //발생 시간
    public float shakeIntensity;        //손떨림 수치
    public int backspaceCount;      //타자 오타 횟수
    public boolean isOnCall;        //통화 중 여부
    public String currentApp;       //현재 실행 중인 앱

}
