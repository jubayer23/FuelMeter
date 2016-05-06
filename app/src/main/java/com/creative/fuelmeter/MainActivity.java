package com.creative.fuelmeter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.creative.fuelmeter.appdata.AppController;

public class MainActivity extends AppCompatActivity {

    EditText ed_fuel_per_km, ed_fuel_price;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (showWarningDialog()) {

                    AppController.getInstance().getPrefManger().setFuelConsumedPerKm(Float.parseFloat(ed_fuel_per_km.getText().toString()));
                    AppController.getInstance().getPrefManger().setFuelConsumedPerKm(Float.parseFloat(ed_fuel_price.getText().toString()));


                }

            }
        });
    }

    private void init() {
        ed_fuel_per_km = (EditText) findViewById(R.id.ed_fuel_per_km);
        ed_fuel_price = (EditText) findViewById(R.id.ed_fuel_price);
        btn_submit = (Button) findViewById(R.id.btn_submit);
    }

    public boolean showWarningDialog() {

        boolean valid = true;

        if (ed_fuel_per_km.getText().toString().isEmpty()) {
            ed_fuel_per_km.setError("Enter Value");
            valid = false;
        } else {
            ed_fuel_per_km.setError(null);
        }

        if (ed_fuel_price.getText().toString().isEmpty()) {
            ed_fuel_price.setError("Enter Value");
            valid = false;
        } else {
            ed_fuel_price.setError(null);
        }

        if (!(ed_fuel_per_km.getText().toString().isEmpty() && ed_fuel_price.getText().toString().isEmpty())) {
            if (ed_fuel_per_km.getText().toString().isEmpty() && !ed_fuel_price.getText().toString().isEmpty()) {
                ed_fuel_per_km.requestFocus();
            }
            if (!ed_fuel_per_km.getText().toString().isEmpty() && ed_fuel_price.getText().toString().isEmpty()) {
                ed_fuel_price.requestFocus();
            }
        }


        return valid;
    }
}
