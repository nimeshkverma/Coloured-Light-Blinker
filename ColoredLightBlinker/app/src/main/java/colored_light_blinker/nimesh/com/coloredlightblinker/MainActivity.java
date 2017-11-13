package colored_light_blinker.nimesh.com.coloredlightblinker;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timer;
    TimerTask timerTask;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.activity_main_id);
        bgElement.setBackgroundColor(Color.YELLOW);
        startColorFlicker();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startColorFlicker();
    }
    @Override
    protected void onStop(){
        super.onStop();
        stoptimertask();

    }
    @Override
    protected void onPause(){
        super.onPause();
        stoptimertask();

    }
    public void startColorFlicker() {
        timer = new Timer();

        initializeTimerTask();
        timer.schedule(timerTask, 1, 1); //
    }

    public void stoptimertask() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                handler.post(new Runnable() {
                    public void run() {
                        ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.activity_main_id);
                        int color = ((ColorDrawable) bgElement.getBackground()).getColor();
                        long time = System.currentTimeMillis();
                        long mod = time % 10000;
                        if (mod <= 2000) {
                            bgElement.setBackgroundColor(Color.MAGENTA);
                        } else if (mod > 2000 && mod <= 4000) {
                            bgElement.setBackgroundColor(Color.RED);
                        } else if (mod > 4000 && mod <= 6000) {
                            bgElement.setBackgroundColor(Color.BLUE);
                        } else if (mod > 6000 && mod <= 8000) {
                            bgElement.setBackgroundColor(Color.CYAN);
                        } else {
                            bgElement.setBackgroundColor(Color.YELLOW);
                        }
                    }

                });
            }
        };
    }
}
