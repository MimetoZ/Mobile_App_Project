package com.example.projecv.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.projecv.modles.Vinetki;

@Database(entities = {Vinetki.class}, version = 1)
public abstract class VinetkaDatebase extends RoomDatabase{

    private static VinetkaDatebase instance;

    public  abstract VinetkaDao vinetkaDao();

    public static synchronized VinetkaDatebase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            VinetkaDatebase.class, "vinetka_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
