package com.example.dice_roller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.*;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        int count = 0;
        public void on_button_click (View view){

            TextView tv = (TextView) this.findViewById(R.id.num);
            Random r = new Random();
            TextView score = this.findViewById(R.id.rslt);
            TextView guess = this.findViewById(R.id.guess);
            TextView nice = this.findViewById(R.id.nice);
            nice.setText("");

            int number = r.nextInt(6) + 1;
            String guessed = guess.getText().toString();

            try {
                tv.setText(number);
                score.setText(count);
            } catch (Exception ex) {
                tv.setText("Number : "+Integer.toString(number));
                int GN = Integer.parseInt(guessed);
                if (GN == number) {
                    count++;
                    score.setText("Score : "+Integer.toString(count));
                    nice.setText("NİCE ONE");

                }
                if(count == 10)
                {
                    nice.setText("You are a CHAMPION");
                }

            }


        }


}
