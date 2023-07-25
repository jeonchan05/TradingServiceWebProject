package com.final_project.stock.dto;

public class KospiIntDto {

    private String date;
    private float value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KospiIntDto [date=" + date + ", value=" + value + "]";
    }
}
