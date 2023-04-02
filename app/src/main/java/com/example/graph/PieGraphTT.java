package com.example.graph;

import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class PieGraphTT {

    final ArrayList<PieEntry> pieTotalExpense;

    public PieGraphTT(){
        pieTotalExpense = new ArrayList<>();

        String[] labels = {"total type 1","total type 2","total type 3","total type 4"};
        int[] values = {10 , 15, 20, 25};

        for(int i = 0; i < labels.length; i++) {
            pieTotalExpense.add(new PieEntry(values[i], labels[i]));
        }
    }

    public ArrayList<PieEntry> getPieTotalEntries() {
        return pieTotalExpense;
    }
}

