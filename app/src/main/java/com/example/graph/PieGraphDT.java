package com.example.graph;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class PieGraphDT {

    final ArrayList<PieEntry> pieDailyExpense;

    public PieGraphDT(){
        pieDailyExpense = new ArrayList<>();

        String[] labels = {"daily type 1","daily type 2","daily type 3","daily type 4"};
        int[] values = {10 , 15, 20, 25};

        for(int i = 0; i < labels.length; i++) {
            pieDailyExpense.add(new PieEntry(values[i], labels[i]));
        }
    }

    public ArrayList<PieEntry> getPieDailyEntries() {
        return pieDailyExpense;
    }
}

