package com.example.pauselock;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface PhisingDao {
    @Insert
    void insert(PhishingEvent event);

    @Query("SELECT * FROM phishing_logs ORDER BY timestamp DESC LIMIT 50")
    List<PhishingEvent> getRecentLogs(); //AI 개발자가 분석요으로 가져갈 도구
}
