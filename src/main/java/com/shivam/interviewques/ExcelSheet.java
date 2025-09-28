package com.shivam.interviewques;

import java.util.HashMap;

public class ExcelSheet {
    HashMap<String, String> sheet = new HashMap<>();

    public void setCell(String cell, String value){
        sheet.put(cell, value);
    }
    // Set value in cell (e.g., "A1")

    public String getCell(String cell){
        return sheet.getOrDefault(cell,"");
    }

    // Get value of cell
    public static void main(String[] args) {
        ExcelSheet excel = new ExcelSheet();
        excel.setCell("A1", "100");
        excel.setCell("B1", "200");
        System.out.println("A1: " + excel.getCell("A1")); // 100
        System.out.println("B1: " + excel.getCell("B1")); // 200
    }
}

