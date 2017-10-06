package me.jayeshbhadja.ganttchart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import me.jayeshbhadja.ganttchartlibrary.activity.Gantt;
import me.jayeshbhadja.ganttchartlibrary.model.GanttData;
import me.jayeshbhadja.ganttchartlibrary.model.Milestone;
import me.jayeshbhadja.ganttchartlibrary.model.Project;
import me.jayeshbhadja.ganttchartlibrary.model.Task;

public class MainActivity extends AppCompatActivity {

    private AppCompatActivity compatActivity;
    private Project project;
    private ArrayList<Task> tasks;
    private ArrayList<Milestone> milestones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.compatActivity = this;
        project = new Project("1", "Test", "2017-05-01", "2017-11-30");
        tasks = new ArrayList<Task>();
        milestones = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Task task = new Task(String.valueOf(i), "Task" + i, "2017-05-05", "2017-06-01", null, null, null);
            tasks.add(task);
        }
        GanttData.initGanttData(project, tasks, milestones);
        Intent intent = new Intent(compatActivity, Gantt.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.gantt, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_gantt:
                GanttData.initGanttData(project, tasks, milestones);
                Intent intent = new Intent(compatActivity, Gantt.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
