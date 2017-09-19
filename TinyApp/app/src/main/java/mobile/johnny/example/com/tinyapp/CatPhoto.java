package mobile.johnny.example.com.tinyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class CatPhoto extends AppCompatActivity {

    RatingBar rate;
    TextView CatRateResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat_photo);

        rate = (RatingBar) findViewById(R.id.rate);
        CatRateResponse = (TextView) findViewById(R.id.CatRateResponse);

        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                CatRateResponse.setText("Rate is " + rating);

            }
        });
    }
}
