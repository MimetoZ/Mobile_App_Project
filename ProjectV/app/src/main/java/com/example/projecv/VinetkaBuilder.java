package com.example.projecv;

import com.example.projecv.modles.Vinetki;

public abstract class VinetkaBuilder {
    public static Vinetki Build(int id, String vinetkaNumber, String carClass, String emissionClass, String startDate, String endDate, String sum, String status){
        Vinetki v = new Vinetki();
        v.setId(id);
        v.setVinetkaNumber(vinetkaNumber);
        v.setCarClass(carClass);
        v.setEmissionClass(emissionClass);
        v.setStartDate(startDate);
        v.setEndDate(endDate);
        v.setSum(sum);
        v.setStatus(status);
        return v;
    }
}
