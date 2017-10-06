package me.jayeshbhadja.ganttchartlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.format.DateTimeFormat;

import java.util.List;

import me.jayeshbhadja.ganttchartlibrary.R;
import me.jayeshbhadja.ganttchartlibrary.model.Milestone;
import me.jayeshbhadja.ganttchartlibrary.utils.AppConstant;

public class ScaleView extends View {
    private static final String TAG = ScaleView.class.getSimpleName();
    private float scale;
    private DateTime minDate;
    private DateTime maxDate;

    private Paint mFillPaint;
    private Paint mLinePaint;
    private Paint mTodayPaint;
    private Paint mMilestonePaint;

    private int nx;
    private int dx;
    private List<Milestone> milestones;

    public ScaleView(Context context) {
        this(context, null);
    }

    public ScaleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScaleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scale = getContext().getResources().getDisplayMetrics().density;
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.GRAY);

        mMilestonePaint = new Paint();
        mMilestonePaint.setColor(ContextCompat.getColor(context, R.color.milestone_line));
        mMilestonePaint.setStrokeWidth(3.333333333f * scale);

        mTodayPaint = new Paint();
        mTodayPaint.setColor(ContextCompat.getColor(context, R.color.today_line));
        mTodayPaint.setStrokeWidth(3.333333333f * scale);

        mFillPaint = new Paint();
        mFillPaint.setColor(ContextCompat.getColor(context, R.color.scale_dayoff));
    }

    public void setRange(DateTime minDate, DateTime maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    public void setXAxis(int nx, int dx) {
        this.nx = nx;
        this.dx = dx;
    }

    public void setMilestones(List<Milestone> milestones) {
        this.milestones = milestones;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.rgb(255, 255, 255));
        int height = canvas.getHeight();

        for (int i = 0; i < nx; i++) {
            int dayOfWeek = minDate.getDayOfWeek();

//            In the case of Saturday and Sunday, color the background
            if (dayOfWeek == 6 || dayOfWeek == 7) {
                canvas.drawRect(dx * i, 0, dx * (i + 1), height, mFillPaint);
            }

            // Separator line
            if (dayOfWeek == 1) {
                canvas.drawLine(dx * (i - 1), 0, dx * (i - 1), height, mLinePaint);
            }

            if (DateTimeComparator.getDateOnlyInstance().compare(DateTime.now(), minDate) == 0) {
                canvas.drawLine(dx * i, 0, dx * i, height, mTodayPaint);
            }

            if (milestones != null && !milestones.isEmpty()) {
                for (Milestone milestone : milestones) {
                    DateTime milestoneDeadline = DateTime.parse(milestone.getDeadline(), DateTimeFormat.forPattern(AppConstant.DATE_FORMAT_yyyy_MM_dd));
                    if (DateTimeComparator.getDateOnlyInstance().compare(milestoneDeadline, minDate) == 0) {
                        canvas.drawLine(dx * i, 0, dx * i, height, mMilestonePaint);
                    }
                }
            }

            minDate = minDate.plusDays(1);
        }
    }
}
