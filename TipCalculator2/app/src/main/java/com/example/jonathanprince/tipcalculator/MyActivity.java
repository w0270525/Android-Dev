package com.example.jonathanprince.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.text.*;

public class MyActivity extends Activity {

    //Constants
    private static final String BILL_TOTAL = "BILL_TOTAL";
    private static final String CUSTOM_PERCENT="CUSTOM_PERCENT";


    private double currentBillTotal;//bill amount entered by user.
    private int currentCustomPercent;//tip % set with seekbar.

    //Controls i.e.: views


    private EditText total10EditText;//Displays 10% total tip.
    private EditText total15EditText;//Displays 15% total tip.
    private EditText total20EditText;//Displays 20% total tip.
    private EditText tip10EditText;//Displays 10% tip amount.
    private EditText tip15EditText;//Displays 15% tip amount.
    private EditText tip20EditText;//Displays 20% tip amount.
    private EditText customTipTextView;
    private EditText tipCustomEditText;
    private EditText totalCustomEditText;
    private EditText customSeekBar;
    private EditText billEditText;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
