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
                        long mod = time % 12000;
                        if (mod <= 1000) {
                            bgElement.setBackgroundColor(Color.rgb(148, 0, 211));
                        } else if (mod > 1000 && mod <= 2000) {
                            bgElement.setBackgroundColor(Color.rgb(75, 0, 130));
                        } else if (mod > 2000 && mod <= 3000) {
                            bgElement.setBackgroundColor(Color.rgb(0, 0, 255));
                        } else if (mod > 3000 && mod <= 4000) {
                            bgElement.setBackgroundColor(Color.rgb(0, 255, 0));
                        } else if (mod > 4000 && mod <= 5000) {
                            bgElement.setBackgroundColor(Color.rgb(255, 255, 0));
                        }else if (mod > 5000 && mod <= 6000) {
                            bgElement.setBackgroundColor(Color.rgb(255, 127, 0));
                        }else if (mod > 6000 && mod <= 7000) {
                            bgElement.setBackgroundColor(Color.rgb(255, 0 , 0));
                        }else if (mod > 7000 && mod <= 8000) {
                            bgElement.setBackgroundColor(Color.rgb(255, 127, 0));
                        }else if (mod > 8000 && mod <= 9000) {
                            bgElement.setBackgroundColor(Color.rgb(255, 255, 0));
                        }else if (mod > 9000 && mod <= 10000) {
                            bgElement.setBackgroundColor(Color.rgb(0, 255, 0));
                        }else if (mod > 10000 && mod <= 11000) {
                            bgElement.setBackgroundColor(Color.rgb(0, 0, 255));
                        } else {
                            bgElement.setBackgroundColor(Color.rgb(75, 0, 130));
                        }
                    }

                });
            }
        };
    }
}