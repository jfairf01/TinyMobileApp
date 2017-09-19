package mobile.johnny.example.com.tinyapp;

import android.os.Bundle;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.TextView;

public class Velocity extends AppCompatActivity {

    TextView XVelocity;
    TextView YVelocity;
    TextView TotVelocity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_velocity);
    }

    private static final String DEBUG_TAG = "Velocity";
    private VelocityTracker mVelocityTracker = null;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int index = event.getActionIndex();
        int action = event.getActionMasked();
        int pointerId = event.getPointerId(index);
        XVelocity = (TextView) findViewById(R.id.XVelocity);
        YVelocity = (TextView) findViewById(R.id.YVelocity);
        TotVelocity = (TextView) findViewById(R.id.TotVelocity);

        switch(action) {
            case MotionEvent.ACTION_DOWN:
                if(mVelocityTracker == null) {
                    // Retrieve a new VelocityTracker object to watch the
                    // velocity of a motion.
                    mVelocityTracker = VelocityTracker.obtain();
                }
                else {
                    // Reset the velocity tracker back to its initial state.
                    mVelocityTracker.clear();
                }
                // Add a user's movement to the tracker.
                mVelocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event);
                // When you want to determine the velocity, call
                // computeCurrentVelocity(). Then call getXVelocity()
                // and getYVelocity() to retrieve the velocity for each pointer ID.
                mVelocityTracker.computeCurrentVelocity(1000);
                // Log velocity of pixels per second
                // Best practice to use VelocityTrackerCompat where possible.
                float xvel = VelocityTrackerCompat.getXVelocity(mVelocityTracker,
                        pointerId);
                float yvel = VelocityTrackerCompat.getYVelocity(mVelocityTracker,
                        pointerId);
                float totvelsq = (float) ((float) Math.pow(xvel,2.0) + (float) Math.pow(yvel,2.0));
                float totvel = (float) Math.pow(totvelsq, .5);

                XVelocity.setText(Float.toString(Math.abs(xvel)));
                YVelocity.setText(Float.toString(Math.abs(yvel)));
                TotVelocity.setText(Float.toString(Math.abs(totvel)));

                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // Return a VelocityTracker object back to be re-used by others.
//                mVelocityTracker.recycle();
                break;
        }
        return true;
    }
}
