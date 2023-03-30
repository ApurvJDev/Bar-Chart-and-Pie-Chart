package com.example.graph;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class PieGraph {

    final ArrayList<PieEntry> pieExpense;

    public PieGraph(){
        pieExpense = new ArrayList<>();

        String[] labels = {"Test1","Test2","Test3","Test4"};
        int[] values = {10 , 15, 20, 25};

        for(int i = 0; i < labels.length; i++) {
            pieExpense.add(new PieEntry(values[i], labels[i]));
        }
    }

    public ArrayList<PieEntry> getPieEntries() {
        return pieExpense;
    }
}
