package com.example.cisc.sound;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private SoundPool soundPool;
    int sample1 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC,0);

        try
        {
            //create objects of the 2 required classes
            AssetManager assetsManager = getAssets();
            AssetFileDescriptor descriptor;

            //create our three fx in memory ready for use
            descriptor = assetsManager.openFd("jump.wav");
            sample1 = soundPool.load(descriptor, 0);
        }
        catch (IOException e)
        {

            Context context = getApplicationContext();
            CharSequence text = "BUTTON NOT FOUND!";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        Button buttonS =  (Button) findViewById(R.id.buttonSound);
        buttonS.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch (v.getId())
        {
            case R.id.buttonSound:  //when the first button is pressed
                //play sample 1
                soundPool.play(sample1, 1, 1, 0, 0, 1);
                break;
        }
    }
}

