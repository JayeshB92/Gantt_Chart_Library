package me.jayeshbhadja.ganttchartlibrary.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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

public class CalendarView extends View {
    private static final String TAG = CalendarView.class.getSimpleName();
    private DateTime minDate;
    private DateTime maxDate;
    private List<Milestone> milestones;

    private Paint mCharPaint;
    private Paint mCharTodayPaint;
    private Paint mTodayPaint;
    private Paint mCharMilestonePaint;
    private Paint mMilestonePaint;
    private Paint mTextPaint;
    private Paint mFillPaint;
    private Paint mLinePaint;

    private Rect textBounds;

    private float scale;
    private int nx;
    private int dx;

    public CalendarView(Context context) {
        this(context, null);
    }

    public CalendarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CalendarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scale = getContext().getResources().getDisplayMetrics().density;

        mCharPaint = new Paint();
        mCharPaint.setAntiAlias(true);
        mCharPaint.setColor(Color.BLACK);
        mCharPaint.setTextSize(8.f * scale);

        mLinePaint = new Paint();
        mLinePaint.setColor(Color.GRAY);

        mTodayPaint = new Paint();
        mTodayPaint.setColor(ContextCompat.getColor(context, R.color.today_line));
        mTodayPaint.setStrokeWidth(3.333333333f * scale);

        mTextPaint = new Paint();

        mMilestonePaint = new Paint();
        mMilestonePaint.setColor(ContextCompat.getColor(context, R.color.milestone_line));
        mMilestonePaint.setStrokeWidth(3.333333333f * scale);

        textBounds = new Rect();

        mCharMilestonePaint = new Paint();
        mCharMilestonePaint.setAntiAlias(true);
        mCharMilestonePaint.setColor(ContextCompat.getColor(context, R.color.bar_text));
        mCharMilestonePaint.setTextSize(10.f * scale);
        mCharMilestonePaint.setTextAlign(Paint.Align.CENTER);

        mCharTodayPaint = new Paint();
        mCharTodayPaint.setAntiAlias(true);
        mCharTodayPaint.setColor(ContextCompat.getColor(context, R.color.bar_text));
        mCharTodayPaint.setTextSize(10.f * scale);
        mCharTodayPaint.setTextAlign(Paint.Align.CENTER);

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

        /**
         * FOR Table Headers
         */

        for (int i = 0; i < nx; i++) {
            int dayOfMonth = minDate.getDayOfMonth();
            int dayOfWeek = minDate.getDayOfWeek();

            // Drawing the month & year
            if (dayOfMonth == 1) {
                canvas.drawText(minDate.monthOfYear().getAsShortText() + ", " + minDate.year().getAsShortText(), dx * i + 3 * scale, height / 2 - 3 * scale, mCharPaint);
                canvas.drawLine(dx * i, 0, dx * i, height / 2, mLinePaint);
//                canvas.drawLine(dx * i, 0, dx * i, height / 2, mLinePaint);
            }

//            In the case of Saturday and Sunday, color the background
            if (dayOfWeek == 6 || dayOfWeek == 7) {
                canvas.drawRect(dx * i, height / 2, dx * (i + 1), height, mFillPaint);
                canvas.drawLine(dx * i, height / 2, dx * (i + 1), height / 2, mLinePaint);
                canvas.drawLine(dx * i, height - 3 / 2, dx * (i + 1), height - 3 / 2, mLinePaint);
            }

            if (dayOfWeek == 1 && dayOfMonth != 1 && i == 0) {
                canvas.drawText(minDate.monthOfYear().getAsShortText() + ", " + minDate.year().getAsShortText(), dx * i + 3 * scale, height / 2 - 3 * scale, mCharPaint);
            }

//            Draw the day
            if (dayOfWeek == 1) {
                canvas.drawText(getResources().getString(R.string.text_gantt_week) + minDate.weekOfWeekyear().getAsShortText(), dx * i + 9, height - 10, mCharPaint);
                /**
                 * drawLine StartX, StartY,  StopX, StopY, color
                 */
                canvas.drawLine(dx * (i - 1), height / 2, dx * (i + 6), height / 2, mLinePaint);
                canvas.drawLine(dx * (i - 1), height - 3 / 2, dx * (i + 6), height - 3 / 2, mLinePaint);
            }
            // Separator line
            if (dayOfWeek == 7) {
                /**
                 * FOR Vertical Line
                 */
                canvas.drawLine(dx * i, height / 2, dx * i, height, mLinePaint);
                /**
                 * FOR Horizontal Line
                 */
//                canvas.drawLine(dx * i, height / 2, dx * (i + 1) - 1, height / 2, mLinePaint);
            }

            if (DateTimeComparator.getDateOnlyInstance().compare(DateTime.now(), minDate) == 0) {
                String textToday = getResources().getString(R.string.text_gantt_today);
                canvas.drawLine(dx * i, 0, dx * i, height, mTodayPaint);
                canvas.drawRect(dx * i, 0, dx * (i + 5f), height / 2, mTodayPaint);
                canvas.drawText(textToday, dx * (i + 2.2f), height / 2 - 3 * scale, mCharTodayPaint);
            }

            if (milestones != null && !milestones.isEmpty()) {
                for (Milestone milestone : milestones) {
                    DateTime milestoneDeadline = DateTime.parse(milestone.getDeadline(), DateTimeFormat.forPattern(AppConstant.DATE_FORMAT_yyyy_MM_dd));
                    if (DateTimeComparator.getDateOnlyInstance().compare(milestoneDeadline, minDate) == 0) {
                        String title = milestone.getTitle();
                        canvas.drawLine(dx * i, 0, dx * i, height, mMilestonePaint);
                        canvas.drawRect(dx * i, 0, dx * (i + (0.823529412f * title.length())), height / 2, mMilestonePaint);
//                        canvas.drawRect(dx * i, 0, dx * (i + (14f)), height / 2, mMilestonePaint);
                        canvas.drawText(milestone.getTitle(), dx * (i + 7f), height / 2 - 3 * scale, mCharMilestonePaint);
                    }
                }
            }

            minDate = minDate.plusDays(1);
        }
    }
}
