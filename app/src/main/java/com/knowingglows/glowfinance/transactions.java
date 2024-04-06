package com.knowingglows.glowfinance;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Map;

public class transactions extends AppCompatActivity
{

    LineChart lineChart;
    AppCompatButton
            bottom_navigation_home,
            bottom_navigation_transactions, bottom_navigation_addrecords,
            bottom_navigation_profile, bottom_navigation_report;

    @Override
    protected void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        bottom_navigation_home = findViewById(R.id.bottom_navigation_home);
        bottom_navigation_transactions = findViewById(R.id.bottom_navigation_transactions);
        bottom_navigation_addrecords = findViewById(R.id.bottom_navigation_addrecords);
        bottom_navigation_profile = findViewById(R.id.bottom_navigation_profile);
        bottom_navigation_report = findViewById(R.id.bottom_navigation_report);
        lineChart = findViewById(R.id.transactions_chart);
        BottomNavigationBarFunctionality();
        LineChartTest();

    }

    public void BottomNavigationBarFunctionality()
    {
        bottom_navigation_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(transactions.this, home.class));
            }
        });

        bottom_navigation_transactions.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(transactions.this, transactions.class));
            }
        });

        bottom_navigation_addrecords.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        startActivity(new Intent(transactions.this, addrecord_income.class));
                    }
                });

        bottom_navigation_profile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(transactions.this, profile.class));
            }
        });

        bottom_navigation_report.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(transactions.this, report.class));
            }
        });

    }

    public void LineChartTest()
    {
        int colour = Color.parseColor("#0DA6C2");
        // Create data entries
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 4));
        entries.add(new Entry(1, 8));
        entries.add(new Entry(2, 6));
        entries.add(new Entry(3, 2));
        entries.add(new Entry(4, 7));

        // Create a dataset with entries
        LineDataSet dataSet = new LineDataSet(entries, "Label"); // Label for the dataset
        dataSet.setColor(colour);
        dataSet.setValueTextColor(Color.BLUE);

        // Set curve line mode
        dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        dataSet.setFillColor(colour);

        // Set fill color
        dataSet.setDrawFilled(true);// Custom fill drawable

        // Create a LineData object with the dataset
        LineData lineData = new LineData(dataSet);

        // Set LineData to the chart
        lineChart.setData(lineData);

        // Customize chart appearance
        Description desc = new Description();
        desc.setText("Your Chart Description");
        lineChart.setDescription(desc);
        lineChart.getXAxis().setDrawGridLines(false); // Remove grid lines from X axis
        lineChart.getAxisLeft().setDrawGridLines(false); // Remove grid lines from left Y axis
        lineChart.getAxisRight().setDrawGridLines(false); // Remove grid lines from right Y axis

        // Set animation
        lineChart.animateX(1500, Easing.EaseInOutExpo); // X-axis animation
        lineChart.animateY(1500, Easing.EaseInOutExpo); // Y-axis animation
        lineChart.invalidate(); // Refresh the chart// Refresh the chart
    }
}