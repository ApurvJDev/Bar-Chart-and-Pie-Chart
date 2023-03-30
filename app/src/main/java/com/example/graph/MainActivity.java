package com.example.graph;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarGraph barGraph = new BarGraph();
    PieGraph pieGraph = new PieGraph();
    ArrayList<BarEntry> barExpense = barGraph.getBarEntries();
    ArrayList<PieEntry> pieExpense = pieGraph.getPieEntries();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //   BAR CHART

        BarChart barChart = findViewById(R.id.barChart);

        BarDataSet barDataSet = new BarDataSet(barExpense,"Expenses");

        BarData barData = new BarData(barDataSet);

        barChart.setData(barData);

        barChart.getDescription().setEnabled(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(barGraph.getLabels()));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);

        barChart.setFitBars(true);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(16f);
        barChart.animateY(2000);


        // PIE CHART


        PieChart pieChart = findViewById(R.id.pieChart);

        PieDataSet pieDataSet = new PieDataSet(pieExpense,"Expenses");

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Expenses");
        pieChart.animate();


    }
}