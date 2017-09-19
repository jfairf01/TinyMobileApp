package mobile.johnny.example.com.tinyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button AddBtn = (Button) findViewById(R.id.AddBtn);
        Button SubBtn = (Button) findViewById(R.id.SubBtn);
        Button MultBtn = (Button) findViewById(R.id.MultBtn);
        Button DivBtn = (Button) findViewById(R.id.DivBtn);

        AddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Number1 = (EditText) findViewById(R.id.Number1);
                EditText Number2 = (EditText) findViewById(R.id.Number2);
                TextView ResultText = (TextView) findViewById(R.id.ResultText);
                if(Number1 != null && !Number1.getText().toString().isEmpty() && Number2 != null && !Number2.getText().toString().isEmpty()) {
                    float num1 = Float.parseFloat(Number1.getText().toString());
                    float num2 = Float.parseFloat(Number2.getText().toString());
                    float result = num1 + num2;
                    if(result == Math.ceil(result)){
                        ResultText.setText(Math.round(result) + "");
                    }
                    else {
                        ResultText.setText(result + "");
                    }
                }
                else {
                    ResultText.setText("Please input 2 numbers");
                }
            };
        });

        SubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Number1 = (EditText) findViewById(R.id.Number1);
                EditText Number2 = (EditText) findViewById(R.id.Number2);
                TextView ResultText = (TextView) findViewById(R.id.ResultText);

                if(Number1 != null && !Number1.getText().toString().isEmpty() && Number2 != null && !Number2.getText().toString().isEmpty()) {
                    float num1 = Float.parseFloat(Number1.getText().toString());
                    float num2 = Float.parseFloat(Number2.getText().toString());
                    float result = num1 - num2;
                    if(result == Math.ceil(result)){
                        ResultText.setText(Math.round(result) + "");
                    }
                    else {
                        ResultText.setText(result + "");
                    }
                }
                else {
                    ResultText.setText("Please input 2 numbers");
                }
            };
        });

        MultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Number1 = (EditText) findViewById(R.id.Number1);
                EditText Number2 = (EditText) findViewById(R.id.Number2);
                TextView ResultText = (TextView) findViewById(R.id.ResultText);

                if(Number1 != null && !Number1.getText().toString().isEmpty() && Number2 != null && !Number2.getText().toString().isEmpty()) {
                    float num1 = Float.parseFloat(Number1.getText().toString());
                    float num2 = Float.parseFloat(Number2.getText().toString());
                    float result = num1 * num2;
                    if(result == Math.ceil(result)){
                        ResultText.setText(Math.round(result) + "");
                    }
                    else {
                        ResultText.setText(result + "");
                    }
                }
                else {
                    ResultText.setText("Please input 2 numbers");
                }
            };
        });

        DivBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText Number1 = (EditText) findViewById(R.id.Number1);
                EditText Number2 = (EditText) findViewById(R.id.Number2);
                TextView ResultText = (TextView) findViewById(R.id.ResultText);

                if(Number1 != null && !Number1.getText().toString().isEmpty() && Number2 != null && !Number2.getText().toString().isEmpty()) {
                    float num1 = Float.parseFloat(Number1.getText().toString());
                    float num2 = Float.parseFloat(Number2.getText().toString());
                    if (num2 == 0){
                        ResultText.setText("Cannot divide by 0");
                    }
                    else {
                        float result = num1 / num2;
                        if(result == Math.ceil(result)){
                            ResultText.setText(Math.round(result) + "");
                        }
                        else {
                            ResultText.setText(result + "");
                        }
                    }
                }
                else {
                    ResultText.setText("Please input 2 numbers");
                }
            };
        });
    }
}
