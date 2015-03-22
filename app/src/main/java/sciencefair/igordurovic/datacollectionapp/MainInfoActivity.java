package sciencefair.igordurovic.datacollectionapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import java.util.Date;


public class MainInfoActivity extends ActionBarActivity {

    public static final String PREFS = "examplePrefs";
    public static int options;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_info);

       /* Entity person = new Entity("Person");
        person.setProperty("Age", 16);
        person.setProperty("Gender", "male");
        person.setProperty("InfectiousPeriod", 5);
        person.setProperty("Status", "immune");
        datastore.put(person)*/;

        /*final EditText et = (EditText)findViewById(R.id.EditText);
        Button nextAct = (Button)findViewById(R.id.button);

        nextAct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String message = et.getText().toString();
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                SharedPreferences.Editor editor = examplePrefs.edit();
                editor.putString("userMessage", message);
                editor.commit();

                Intent i = new Intent(getApplicationContext(), SecondaryActivity.class);
                startActivity(i);
            }
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_info, menu);
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

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    options = 1;
                    break;
            case R.id.radioButton2:
                if (checked)
                    options = 2;
                    break;
            case R.id.radioButton3:
                if(checked)
                    options = 3;
                    break;
        }
    }

    public void onEnterClick(View view){
        switch(options){
            case 1:
                options = 0;
                Intent i = new Intent(getApplicationContext(), Status.class);
                startActivity(i);
                break;
            case 2:
                options = 0;
                Intent i1 = new Intent(getApplicationContext(), Gender.class);
                startActivity(i1);
                break;
            case 3:
                options = 0;
                Intent i2 = new Intent(getApplicationContext(), Age.class);
                startActivity(i2);
                break;
            case 4:
                //Intent i3 = new Intent(getApplicationContext(), Else.class);
                //startActivity(i);
                break;
            default:
                Context context = getApplicationContext();
                CharSequence text = "Choose an option";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                break;
        }
    }
}
