package com.example.calculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity
{
    TextView workingsTV, resultsTV;
    String workingstr = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextViews();
    }

    private void initTextViews()
    {
        workingsTV = (TextView)findViewById(R.id.working);
        resultsTV = (TextView)findViewById(R.id.results);
    }

    private void setWorkingstr(String givenValue)
    {
        workingstr = workingstr + givenValue;
        workingsTV.setText(workingstr);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is
        //
        // present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clearOnClick(View view)
    {
        workingsTV.setText("");
        workingstr = "";
        resultsTV.setText("");
    }

    public void moduloOnClick(View view)
    {
        setWorkingstr("%");
    }

    public void divideOnClick(View view)
    {
        setWorkingstr("/");
    }

    public void multiplyOnClick(View view)
    {
        setWorkingstr("*");
    }

    public void subOnClick(View view)
    {
        setWorkingstr("-");
    }

    public void addOnClick(View view)
    {
        setWorkingstr("+");
    }

    public void decimalOnClick(View view)
    {
        setWorkingstr(".");
    }

    public void zeroOnClick(View view)
    {
        setWorkingstr("0");
    }

    public void oneOnClick(View view)
    {
        setWorkingstr("1");
    }

    public void twoOnClick(View view)
    {
        setWorkingstr("2");
    }

    public void threeOnClick(View view)
    {
        setWorkingstr("3");
    }

    public void fourOnClick(View view)
    {
        setWorkingstr("4");
    }

    public void fiveOnClick(View view)
    {
        setWorkingstr("5");
    }

    public void sixOnClick(View view)
    {
        setWorkingstr("6");
    }

    public void sevenOnClick(View view)
    {
        setWorkingstr("7");
    }

    public void eightOnClick(View view)
    {
        setWorkingstr("8");
    }

    public void nineOnClick(View view)
    {
        setWorkingstr("9");
    }

    public void equalsToOnClick(View view)
    {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try
        {
            result = (Double)engine.eval(workingstr);
        }catch (ScriptException e)
        {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
        if(result!=null)
            resultsTV.setText(String.valueOf(result.doubleValue()));

    }
}