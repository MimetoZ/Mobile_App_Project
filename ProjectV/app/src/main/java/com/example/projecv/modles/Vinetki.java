package com.example.projecv.modles;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "vinetki")
public class Vinetki implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String vinetkaNumber;
    private String carClass;
    private String emissionClass;
    private String startDate;
    private String endDate;
    private String sum;
    private String status;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getVinetkaNumber() { return vinetkaNumber; }
    public void setVinetkaNumber(String vinetkaNumber) { this.vinetkaNumber = vinetkaNumber; }

    public String getCarClass() { return carClass; }
    public void setCarClass(String carClass) { this.carClass = carClass; }

    public String getEmissionClass() {return this.emissionClass;}
    public void setEmissionClass(String emissionClass) {this.emissionClass = emissionClass;}

    public String getStartDate() {
        return this.startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return this.endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSum() {
        return this.sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}