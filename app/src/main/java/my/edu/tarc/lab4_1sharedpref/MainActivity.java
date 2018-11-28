package my.edu.tarc.lab4_1sharedpref;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_NAME = "my.edu.tarc.lab4_1sharedpref";
    private TextView textViewName;
    private ImageView imageViewProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.textViewName);
        imageViewProfile = findViewById(R.id.imageViewProfile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_settings2){
            Intent intent = new Intent(this, SettingsActivity2.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        String name;
        int gender; //default = -1, male = 1, female = 0

        name = sharedPreferences.getString(getString(R.string.user_name), getString(R.string.no_name));
        gender = sharedPreferences.getInt(getString(R.string.gender), -1);

        if(gender == 1){
            textViewName.setText("Mr " + name);
            imageViewProfile.setImageResource(R.drawable.male);
        }else if(gender == 0){
            textViewName.setText("Miss " + name);
            imageViewProfile.setImageResource(R.drawable.female);
        }
    }
}
