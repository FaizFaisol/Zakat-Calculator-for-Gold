package com.example.zakatpayment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KeepActivity extends AppCompatActivity implements View.OnClickListener{


    EditText etGram;
    EditText etValue;
    Button keepButton;
    TextView totalweightwear;
    TextView zakatpayable;
    TextView totalzakat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keep);

        etGram = (EditText) findViewById(R.id.goldweight);
        etValue = (EditText) findViewById(R.id.goldvalue);
        keepButton = (Button) findViewById(R.id.keepButton);
        totalweightwear = (TextView) findViewById(R.id.totalweightwear);
        zakatpayable = (TextView) findViewById(R.id.zakatpayable);
        totalzakat = (TextView) findViewById(R.id.totalzakat);

        keepButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.keepButton:

                try{

                    int weight = Integer.parseInt(etGram.getText().toString());
                    double value = Double.parseDouble(etValue.getText().toString());
                    int goldweight = weight - 85;

                    if(goldweight < 0) {
                        double payable = goldweight * value;
                        double totzakat = payable * 0.025;

                        totalweightwear.setText("Gold weight - Uruf :" + goldweight + " gram");
                        zakatpayable.setText("You do not need to pay for gold zakat");

                    }else{

                        double payable = goldweight * value;
                        double totzakat = payable * 0.025;

                        totalweightwear.setText("Gold weight - Uruf (85 gram) :" + goldweight + " gram");
                        zakatpayable.setText("Zakat Payable : RM " + payable);
                        totalzakat.setText("Total Zakat : RM " + totzakat);

                    }

                } catch (java.lang.NumberFormatException nfe){

                    Toast toast = Toast.makeText(this, "Please enter a valid value",Toast.LENGTH_SHORT);
                    toast.show();


                } catch(Exception exp) {

                    Toast toast = Toast.makeText(this, "Unknown Exception" + exp.getMessage(),Toast.LENGTH_SHORT);
                    toast.show();

                    Log.d("Exception",exp.getMessage());

                }


                break;

        }

    }
}