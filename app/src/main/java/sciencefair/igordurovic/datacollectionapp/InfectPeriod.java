package sciencefair.igordurovic.datacollectionapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class InfectPeriod extends ActionBarActivity {

    public static final String PREFS = "SharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infect_period);

        final EditText et = (EditText)findViewById(R.id.editText);
        Button nextAct = (Button)findViewById(R.id.save_i);
        Button loadAct = (Button)findViewById(R.id.load_i);

        nextAct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String message = et.getText().toString();
                int IPeriod = Integer.parseInt(message);
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                SharedPreferences.Editor editor = examplePrefs.edit();
                editor.putInt("IPeriod", IPeriod);
                editor.commit();
            }
        });
        loadAct.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                TextView tv = (TextView)findViewById(R.id.output_i);
                tv.setTextSize(20);

                int userIPeriod = examplePrefs.getInt("IPeriod", 0);
                tv.setText("Infectious Period: " + Integer.toString(userIPeriod));

            }

        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_age, menu);
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
}
