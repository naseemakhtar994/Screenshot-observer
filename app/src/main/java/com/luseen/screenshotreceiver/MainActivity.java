package com.luseen.screenshotreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String PATH = Environment.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startService(new Intent(this, ScreenshotObserverService.class));

        FileObserver fileObserver = new FileObserver(PATH, FileObserver.CLOSE_WRITE) {
            @Override
            public void onEvent(int event, String path) {
                Log.e("onEvent ", "event " + event);
                Log.e("onEvent ", "path " + path);

            }
        };
        //fileObserver.startWatching();
    }
}