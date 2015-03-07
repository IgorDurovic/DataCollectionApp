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


public class Age extends ActionBarActivity {

    public static final String PREFS = "SharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

        final EditText et = (EditText)findViewById(R.id.editText);
        Button nextAct = (Button)findViewById(R.id.save);
        Button loadAct = (Button)findViewById(R.id.load);

        nextAct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String message = et.getText().toString();
                int age = Integer.parseInt(message);
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                SharedPreferences.Editor editor = examplePrefs.edit();
                editor.putInt("Age", age);
                editor.commit();
            }
        });
        loadAct.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                TextView tv = (TextView)findViewById(R.id.output);
                tv.setTextSize(20);

                int userAge = examplePrefs.getInt("Age", 0);
                tv.setText("Age: " + Integer.toString(userAge));

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
