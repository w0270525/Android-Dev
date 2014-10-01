package jonathanprince.nscc.com.jonscalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

//autoimport to take some of the String.ValueOf nonsense out.
import static java.lang.String.valueOf;


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
    String operator="";
    String newOperator="";

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

       //instantiate my math class to do all the heavy lifting.
        final myMath calcMath=new myMath();

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

                newOperator="*";
                tvOutput.setText(calcMath.doMath(operator, newOperator));

            }
        });
        btnZero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if(rightString.equals(""))
                {
                    rightString="0";
                    tvOutput.setText(rightString);
                }
                if(rightString.equals("0"))
                {
                    tvOutput.setText(rightString);
                }
                else {

                   tvOutput.setText(rightString+"0");
                }
            }
        });
        btnDecimal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //checks for any decimals.
                if (rightString.matches("^[\\d]*$")) {

                    rightString+=".";
                    tvOutput.setText(rightString);


                }
               //verifies if it is an empty string
                else if (rightString.equals(""))
                {
                   rightString="0.";
                    tvOutput.setText(rightString);
                }
                else
                {

                    tvOutput.setText(rightString);
                }
            }
        });
        btnDivide.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                newOperator="/";
                tvOutput.setText(calcMath.doMath(operator, newOperator));
            }
        });
        btnEqual.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                newOperator="=";
                tvOutput.setText(calcMath.doMath(operator, "="));
            }
        });
        btnMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //trapping needed

                tvOutput.setText(calcMath.doMath(operator, "-"));
            }
        });
        btnPlusMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               //need to * -1
                rightString= valueOf(Double.parseDouble(rightString) * (-1));
                tvOutput.setText(rightString);
            }
        });

        btnPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

               String newText;

              newText=calcMath.doMath(operator, "+");
                tvOutput.setText(newText);
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
                if(rightString != "") {
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

    public  boolean decimalCheck(String rightSide) {

        int decCount=0;



        for (int i = 0 ; i <= rightSide.length() ; i++) {
            char c = rightSide.charAt(i);
           if (c=='.') {
           decCount++;
           }
            if (decCount==1) {
                return false;
            }
        }

     return true;

    }

    public String doMath(String oldOperator, String newOperator) {
        if(leftString.equals("")) {

            operator = newOperator;
            leftString = rightString;
            rightString = "";
            return "";
            }




        if (oldOperator.equals("+")) {
            return add(leftString, rightString, operator, newOperator);
        } else if
                (oldOperator.equals("-")) {
            return minus(leftString, rightString, operator, newOperator);
        } else if
                (oldOperator.equals("*")) {
            return multiply(leftString, rightString, operator,newOperator);
        } else if
                (oldOperator.equals("/")) {
            return divide(leftString, rightString, operator, newOperator);
        } else if
                (oldOperator.equals("=")) {
            equals(leftString, rightString, operator);
        }


        if (operator=="") {
            operator = newOperator;
        }



        //should never get here.
        return "Error";
    }

    private String multiply(String leftSide, String rightSide, String oldOperator, String newerOperator) {

        String temp;
        temp=valueOf(Double.parseDouble(leftSide) * Double.parseDouble(rightSide));
        operator=newerOperator;
        rightString="";
        leftString=temp;
        return leftString;
    }

    private String divide(String leftSide, String rightSide, String oldOperator, String newerOperator) {
        if (rightSide.equals("0"))
        {
            return "NaN";
        }
        String temp;
        temp=valueOf(Double.parseDouble(leftSide) / Double.parseDouble(rightSide));
        operator=newerOperator;
        rightString="";
        leftString=temp;
        return leftString;

    }
    private String minus(String leftSide, String rightSide, String oldOperator, String newerOperator) {

        String temp;
        temp=valueOf(Double.parseDouble(leftSide) - Double.parseDouble(rightSide));

        operator=newerOperator;
        rightString="";
        leftString=temp;
        return leftString;
    }
    private String add(String leftSide, String rightSide, String oldOperator, String newerOperator) {

        String temp;
        temp=valueOf(Double.parseDouble(leftSide) + Double.parseDouble(rightSide));
        operator=newerOperator;
        rightString="";
        leftString=temp;
        return leftString;
    }
    private void equals(String leftSide, String rightSide, String oPerator) {
        doMath(rightSide,oPerator);
    }


}





}
