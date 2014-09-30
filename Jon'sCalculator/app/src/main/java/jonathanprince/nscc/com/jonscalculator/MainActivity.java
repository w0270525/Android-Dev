package jonathanprince.nscc.com.jonscalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import java.util.regex.*;


public class MainActivity extends Activity {

    TextView tvOutput;
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

    //Variables to assign entered content to a string.
    String leftString="";
    String rightString="";
    String operator;

    //Variables to assign strings to numbers



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

        tvOutput=(TextView)findViewById(R.id.tvOutput);

        //and here goes nothing. On click listeners for every button.
        btnClear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                //resets the calculator.
                tvOutput.setText("");
                leftString="";
                rightString="";

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
//   /^(\d+\.?\d*|\.\d+)$/  ^/^(\d+\.?\d*|\.\d+)$/
                String myRegex="/^(?=.)\\d*(\\.\\d{1,9})?$/";
                if (myRegex.matches(rightString))

                {
                   tvOutput.setText("fail");
                } if (rightString.equals(""))
                {
                   rightString="0.";
                    tvOutput.setText(rightString);
                }else
                {
                    rightString+=".";
                    tvOutput.setText(rightString);
                }
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
                //trapping needed


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
                rightString+= "1";
                tvOutput.setText(rightString);
            }
        });
        btnTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="2";
                tvOutput.setText(rightString );
            }
        });
        btnThree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="3";
                tvOutput.setText(rightString);
            }
        });
        btnFour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="4";
                tvOutput.setText(rightString);
            }
        });
        btnFive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="5";
                tvOutput.setText(rightString);
            }
        });
        btnSix.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="6";
                tvOutput.setText(rightString);
            }
        });
        btnSeven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="7";
               tvOutput.setText(rightString);
            }
        });
        btnEight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="8";
                tvOutput.setText(rightString);
            }
        });
        btnNine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                rightString+="9";
                tvOutput.setText(rightString);
            }
        });
        btnZero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rightString!="") {
                    rightString += "0";
                    tvOutput.setText(rightString);
                }
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



public class myMath {

    myMath(){

    }

    public String doMath(String operator) {
        if (operator.equals("+")) {
            return multiply(leftString, rightString);
        }
        else if
                (operator.equals("-")) {
            return minus(leftString, rightString);
        } else if
                (operator.equals("*")) {
            return multiply(leftString, rightString);
        } else
                 {
            return divide(leftString, rightString);
        }


    }

    private String multiply(String leftSide, String rightSide) {

        return String.valueOf(Double.parseDouble(leftSide) * Double.parseDouble(rightSide));

    }

    private String divide(String leftSide, String rightSide) {
        if (rightSide=="0")
        {
            return "NaN";
        }
        return String.valueOf(Double.parseDouble(leftSide) / Double.parseDouble(rightSide));

    }
    private String minus(String leftSide, String rightSide) {

        return String.valueOf(Double.parseDouble(leftSide) - Double.parseDouble(rightSide));
    }
    private String add(String leftSide, String rightSide) {

        return String.valueOf(Double.parseDouble(leftSide) + Double.parseDouble(rightSide));
    }


}





}
