package com.example.pauselock;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//어떤 Entity를 사용, 버전이 몇인지 정의
@Database(entities = {PhishingEvent.class}, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    //DAO 연결
    public abstract PhishingDao phisingDao();

    private static volatile AppDatabase INSTANCE;

    //DB객체 싱글톤 로직
    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "pauselock_db") // 실제 저장될 파일 이름
                            .fallbackToDestructiveMigration() //버전 변경시 기존 데이터 비우고 새로 만듬
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
