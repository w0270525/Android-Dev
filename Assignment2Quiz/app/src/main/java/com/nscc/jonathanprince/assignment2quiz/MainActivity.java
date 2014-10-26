package com.nscc.jonathanprince.assignment2quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.Toast;


public class MainActivity extends Activity {


    Button btnStartQuiz;
    EditText editName = (EditText)findViewById(R.id.editName);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        btnStartQuiz.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                btnStartQuiz=(Button)findViewById(R.id.btnStartQuiz);

                if(!editName.equals("")) {
                    Intent i = new Intent("QuizActivity");//instantiates intent i
                    Bundle extras = new Bundle();//creates bundle to send to next page by intent

                    //shows toast of name for purposes of toast requirement.
                    Toast.makeText(MainActivity.this,"Hello, "+editName.getText()+", good luck!",Toast.LENGTH_SHORT).show();
                    String newText= String.valueOf(editName.getText());
                    extras.putString("NAME", newText);
                    i.putExtras(extras);
                    startActivityForResult(i,1);
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
}
