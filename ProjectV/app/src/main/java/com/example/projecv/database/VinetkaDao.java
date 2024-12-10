package com.example.projecv.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.projecv.modles.Vinetki;

import java.util.List;

@Dao
public interface VinetkaDao {
    @Insert
    void insertContact(Vinetki vinetki);

    @Query("SELECT * FROM vinetki")
    List<Vinetki> getAllContacts();

    @Query("DELETE FROM vinetki WHERE id = :id")
    void deleteVinetka(int id);

    @Query("UPDATE vinetki SET vinetkaNumber = :vinetkaNumber, " +
            "carClass = :carClass, emissionClass = :emissionClass," +
            "startDate = :startDate, endDate = :endDate," +
            "sum = :sum, status = :status WHERE id = :id")
    void updateVinetka(int id, String vinetkaNumber, String carClass,
                       String emissionClass, String startDate,
                       String endDate, String sum, String status);
}
