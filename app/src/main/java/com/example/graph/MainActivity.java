package com.example.graph;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.ArrayList;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    Button btnNextActivity;

    TextView txtTotal, txtDailyAvg, txtExpenseUsed;

    LinearProgressIndicator progressBar;

    ProgressBar progressIndicator;

    //int x = 50; used for testing

    BarGraph barGraph = new BarGraph();
    PieGraph pieGraph = new PieGraph();
    ArrayList<BarEntry> barExpense = barGraph.getBarEntries();
    ArrayList<PieEntry> pieExpense = pieGraph.getPieEntries();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNextActivity = findViewById(R.id.btnNextActivity);
        btnNextActivity.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,IndividualActivity.class);
            startActivity(intent);
        });

        txtTotal = findViewById(R.id.txtTotal);
        txtDailyAvg = findViewById(R.id.txtDailyAvg);
        txtExpenseUsed = findViewById(R.id.txtExpenseUsed);

        // PROGRESS BAR

        progressBar = findViewById(R.id.progressBar);

        progressIndicator = new ProgressBar(this);

        progressIndicator.setProgress(50);
        //giving the value of expense used in the parameter
        //sorry isse better method nhi mila merko
        //end mai mera brain power exhaust hogya isiliye aisa brute force kiya

        //txtExpenseUsed.setText("Expense Used " + totalExpense + "%");

        progressBar.setIndeterminate(false);


        //   BAR CHART

        BarChart barChart = findViewById(R.id.barChart);

        BarDataSet barDataSet = new BarDataSet(barExpense,"Daily Expenses");

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
        pieDataSet.setLabel("Total expenses");
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("Expenses");
        pieChart.animate();
    }

    public void updateProgress(int totalExpense) {
        progressBar.setProgressCompat(totalExpense,true);
    }
}