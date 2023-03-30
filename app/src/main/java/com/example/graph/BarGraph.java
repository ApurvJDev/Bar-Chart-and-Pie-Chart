package com.example.graph;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

public class BarGraph {
    final ArrayList<BarEntry> barExpense;
    public BarGraph() {
        barExpense = new ArrayList<>();

        String[] labels = {"Apurv", "Jayaram", "Soham","Vedant"};
        int[] values = {17, 20, 15,13};

        for (int i = 0; i < labels.length; i++) {
            barExpense.add(new BarEntry(i, values[i], labels[i]));
        }
    }
    public ArrayList<BarEntry> getBarEntries() {
        return barExpense;
    }
//used get labels cuz i could not see labels in the graph
    public String[] getLabels() {
        String[] labels = new String[barExpense.size()];
        for (int i = 0; i < barExpense.size(); i++) {
            labels[i] = barExpense.get(i).getData().toString();
        }
        return labels;
    }
}

