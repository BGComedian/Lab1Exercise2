package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioGroup;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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

    public void convert(View v) {
        EditText etInput = (EditText) findViewById(R.id.etInput);
        String s = etInput.getText().toString();

        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();

        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();

        double result = Double.parseDouble(s);

        if (selFrom == R.id.rbFrmC) { //The user wants to convert from Celsius.
            if(selTo == R.id.rbToC)
                result = result;
            if(selTo == R.id.rbToF)
                result = ((result * (9.0/5.0)) +32);
            if(selTo == R.id.rbToK)
                result = result + 273.15;
        }

        if (selFrom == R.id.rbFrmF) {
            if(selTo == R.id.rbToC)
                result = ((result - 32) * (5.0/9.0));
            if(selTo == R.id.rbToF)
                result = result;
            if(selTo == R.id.rbToK)
                result = ((result + 459.67) * (5.0/9.0));
        }

        if (selFrom == R.id.rbFrmK) {
            if(selTo == R.id.rbToC)
                result = result-273.15;
            if(selTo == R.id.rbToF)
                result = ((result) * (9.0/5.0)) -3 459.67;
            if(selTo == R.id.rbToK)
                result = result;
        }

        TextView tv = (TextView)findViewById(R.id.tvOutput);
        tv.setText(Double.toString(result));
    }

}
