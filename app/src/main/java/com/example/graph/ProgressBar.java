package com.example.graph;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ProgressBar {

    private TextView txtExpenseUsed;
    final MainActivity mainActivity;

    public ProgressBar(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        txtExpenseUsed = mainActivity.findViewById(R.id.txtExpenseUsed);
    }

    public void setProgress(int totalExpense) {

        txtExpenseUsed.setText("Expense Used " + totalExpense + "%");
        //setting the expense used below the progress bar in a text view
        Timer timer = new Timer();
        TimerTask task = new TimerTask(){

            @Override
            public void run() {

                  mainActivity.updateProgress(totalExpense);

                if(totalExpense == 100) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(task,1000, 1000);
    }
}
