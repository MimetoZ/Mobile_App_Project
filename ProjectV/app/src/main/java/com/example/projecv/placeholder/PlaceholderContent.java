package com.example.projecv.placeholder;

import com.example.projecv.modles.Vinetki;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<PlaceholderItem> ITEMS = new ArrayList<PlaceholderItem>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, PlaceholderItem> ITEM_MAP = new HashMap<String, PlaceholderItem>();

    private static void addItem(PlaceholderItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static PlaceholderItem createPlaceholderItem(int position, Vinetki v) {
        return new PlaceholderItem(""+v.getId(), v.getVinetkaNumber(), v.getEmissionClass(), v.getCarClass(), v.getStartDate(), v.getEndDate(), v.getSum(), v.getStatus());
    }


    public static class PlaceholderItem {
        public final String id;
        public final String vinetkaNumber;
        public final String carClass, emissionClass, startDate, endDate, sum, status;

        public PlaceholderItem(String id, String vinetkaNumber, String carClass,
        String emissionClass, String startDate, String endDate, String sum, String status) {
            this.id = id;
            this.vinetkaNumber = vinetkaNumber;
            this.carClass = carClass;
            this.emissionClass = emissionClass;
            this.startDate = startDate;
            this.endDate = endDate;
            this.sum = sum;
            this.status = status;
        }

        @Override
        public String toString() {
            return "Номер на винетката: "+vinetkaNumber+"\t Класа на колата: "+carClass+"\t " +
                    "Клас на емисиите: "+emissionClass+"\t Начална дата: "+startDate+"\t Крайна дата: "+endDate+"\t " +
                    "Сума: "+sum+"\t Статус: "+status+"\t";
        }
    }
}