package me.jayeshbhadja.ganttchartlibrary.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import me.jayeshbhadja.ganttchartlibrary.R;
import me.jayeshbhadja.ganttchartlibrary.adapter.GanttTableAdapter;
import me.jayeshbhadja.ganttchartlibrary.model.GanttData;

/**
 * Gantt Chart AppCompatActivity to view chart
 */
public class Gantt extends AppCompatActivity {
    private static final String TAG = Gantt.class.getSimpleName();
    private GanttData ganttData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gantt);
        ganttData = GanttData.getGanttData();
        if (ganttData != null)
            setGanttTable();
        else
            Log.e(TAG, "Gantt Data Null, Please Set Gantt Data.");
    }

    private void setGanttTable() {
        TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        GanttTableAdapter baseTableAdapter = new GanttTableAdapter(Gantt.this, ganttData);
        tableFixHeaders.setAdapter(baseTableAdapter);
        tableFixHeaders.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}
