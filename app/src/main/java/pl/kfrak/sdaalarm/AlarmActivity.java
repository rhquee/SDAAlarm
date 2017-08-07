package pl.kfrak.sdaalarm;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmActivity extends AppCompatActivity {

    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if(Build.VERSION.SDK_INT >= 26){
            vibrator.vibrate(VibrationEffect.createOneShot(100, 100));
        } else {
            //pattern - co sekundę (1000)
            //0 jak nie chcemy konczyc powtarzania
            //-1 jak nie chcemy powtarzania w ogole
            long[] pattern = {0, 1000, 100};
            vibrator.vibrate(pattern, 0);
        }

        Button stopButton = (Button) findViewById(R.id.activity_alarm_stop_button);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.cancel();
            }
        });
    }
}
