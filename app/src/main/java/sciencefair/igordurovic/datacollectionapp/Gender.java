package sciencefair.igordurovic.datacollectionapp;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Gender extends ActionBarActivity {

    public static final String PREFS = "SharedPreferences";
    public static int options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        Button nextAct = (Button)findViewById(R.id.save);
        Button loadAct = (Button)findViewById(R.id.load);

        nextAct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(options == 1){
                    String gender = "male";
                    SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                    SharedPreferences.Editor editor = examplePrefs.edit();
                    editor.putString("Gender", gender);
                    editor.commit();
                }
                else if(options == 2){
                    String gender = "female";
                    SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                    SharedPreferences.Editor editor = examplePrefs.edit();
                    editor.putString("Gender", gender);
                    editor.commit();
                }
                else{
                    //do nothing
                }
            }
        });
        loadAct.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                SharedPreferences examplePrefs = getSharedPreferences(PREFS, 0);
                TextView tv = (TextView)findViewById(R.id.output);
                tv.setTextSize(20);

                String userGender = examplePrefs.getString("Gender", "N/A");
                tv.setText("Gender: " + userGender);

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gender, menu);
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
        }
    }
}
