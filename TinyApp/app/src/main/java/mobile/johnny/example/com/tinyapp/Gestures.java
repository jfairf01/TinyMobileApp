package mobile.johnny.example.com.tinyapp;

import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;

public class Gestures extends AppCompatActivity {

    TextView Swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = MotionEventCompat.getActionMasked(event);
        Swipe = (TextView) findViewById(R.id.SwipeText);

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                Swipe.setText("Pressed");
                return true;
            case (MotionEvent.ACTION_MOVE):
                Swipe.setText("Moving");
                return true;
            case (MotionEvent.ACTION_UP):
                Swipe.setText("Lifted");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                Swipe.setText("Cancelled");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                Swipe.setText("Movement Outside of Bounds");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}
