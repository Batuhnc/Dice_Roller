package com.example.dice_roller;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.*;
public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

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
    int rnnum;
    public void roll_the_dice(){
        Random rnd = new Random();
        rnnum = rnd.nextInt(6)+1;

    }

        int count = 0;

        public void on_button_click (View view){

            TextView tv = (TextView) this.findViewById(R.id.num);
            TextView score = this.findViewById(R.id.rslt);
            TextView guess = this.findViewById(R.id.guess);
            TextView nice = this.findViewById(R.id.nice);
            nice.setText("");
            roll_the_dice();
            String guessed = guess.getText().toString();

            try {
                tv.setText(rnnum);
                score.setText(count);
            } catch (Exception ex) {
                tv.setText("Number : "+Integer.toString(rnnum));
                int GN = Integer.parseInt(guessed);
                if (GN == rnnum) {
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

        public void on_button2_click(View view){
            TextView question = (TextView) this.findViewById(R.id.question);
            TextView tv = this.findViewById(R.id.num);
            roll_the_dice();
            try{
                tv.setText(rnnum);
            } catch(Exception ex){
                tv.setText(("Number : "+Integer.toString(rnnum)));
            }

            switch (rnnum)
            {
                case 1:
                    question.setText("If you could go anywhere in the world, where would you go?");
                    break;
                case 2:
                    question.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                    break;
                case 3:
                    question.setText("If you could eat only one food for the rest of your life, what would that be?");
                    break;
                case 4:
                    question.setText("If you won a million dollars, what is the first thing you would buy?");
                    break;
                case 5:
                    question.setText("If you could spaned the day with one fictional character, who would it be?");
                    break;
                case 6:
                    question.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                    break;
            }

        }

    public void sendMessage(View view)
    {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText =   (EditText) this.findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }



}
