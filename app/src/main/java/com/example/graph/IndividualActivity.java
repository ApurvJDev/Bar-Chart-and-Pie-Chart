package com.example.graph;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class IndividualActivity extends AppCompatActivity {

    TextView txtTotalType,txtTypeAvg;
    Button btnPreActivity;

    PieGraphTT pieGraphTT = new PieGraphTT();
    PieGraphDT pieGraphDT = new PieGraphDT();

    ArrayList<PieEntry> pieTotalExpense = pieGraphTT.getPieTotalEntries();
    ArrayList<PieEntry> pieDailyExpense = pieGraphDT.getPieDailyEntries();

    PieChart totalTypePieChart,dailyTypePieChart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);

        txtTotalType = findViewById(R.id.txtTotalType);
        txtTypeAvg = findViewById(R.id.txtTypeAvg);
        btnPreActivity = findViewById(R.id.btnPreActivity);
        btnPreActivity.setOnClickListener(v -> {
            Intent intent = new Intent(IndividualActivity.this,MainActivity.class);
            startActivity(intent);
        });

        // Pie Chart Total Type

        totalTypePieChart = findViewById(R.id.totalTypePieChart);
        PieDataSet pieDataSet = new PieDataSet(pieTotalExpense,"Total Expenses");

        PieData pieData = new PieData(pieDataSet);

        totalTypePieChart.setData(pieData);

        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);
        pieDataSet.setLabel("Total expenses");
        totalTypePieChart.getDescription().setEnabled(false);
        totalTypePieChart.setCenterText("Total Expenses");
        totalTypePieChart.animate();

        // Pie Chart Daily Type

        dailyTypePieChart = findViewById(R.id.dailyTypePieChart);
        PieDataSet pieDataSet2 = new PieDataSet(pieDailyExpense,"Daily Expenses");

        PieData pieData2 = new PieData(pieDataSet2);

        dailyTypePieChart.setData(pieData2);

        pieDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet2.setValueTextColor(Color.BLACK);
        pieDataSet2.setValueTextSize(16f);
        pieDataSet2.setLabel("Total expenses");
        dailyTypePieChart.getDescription().setEnabled(false);
        dailyTypePieChart.setCenterText("Daily Expenses");
        dailyTypePieChart.animate();




    }
}