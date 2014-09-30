package jonathanprince.nscc.com.jonscalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;



public class MainActivity extends Activity {

    EditText tvOutput;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnZero;
    Button btnDecimal;
    Button btnPlusMinus;
    Button btnPlus;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;
    Button btnEqual;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooo boy i don't know if this is right.

        //Setting buttons to the buttons. casting?
        btnClear = (Button)findViewById(R.id.btnClear);
        btnDecimal=(Button)findViewById(R.id.btnDecimal);
        btnDivide=(Button)findViewById(R.id.btnDivide);
        btnEqual=(Button)findViewById(R.id.btnEquals);
        btnMinus=(Button)findViewById(R.id.btnMinus);
        btnPlus=(Button)findViewById(R.id.btnPlus);
        btnPlusMinus=(Button)findViewById(R.id.btnPlusMinus);
        btnMultiply=(Button)findViewById(R.id.btnMultiply);
        btnOne=(Button)findViewById(R.id.btnOne);
        btnTwo=(Button)findViewById(R.id.btnTwo);
        btnThree=(Button)findViewById(R.id.btnThree);
        btnFour=(Button)findViewById(R.id.btnFour);
        btnFive=(Button)findViewById(R.id.btnFive);
        btnSix=(Button)findViewById(R.id.btnSix);
        btnSeven=(Button)findViewById(R.id.btnSeven);
        btnEight=(Button)findViewById(R.id.btnEight);
        btnNine=(Button)findViewById(R.id.btnNine);
        btnZero=(Button)findViewById(R.id.btnZero);

        tvOutput=(EditText)findViewById(R.id.tvOutput);

        //and here goes nothing. On click listeners for every button.
        btnClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnMultiply.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnZero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnDecimal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnDivide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnEqual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnPlusMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnMultiply.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnThree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnFour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnFive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnSix.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnSeven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnEight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnNine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
