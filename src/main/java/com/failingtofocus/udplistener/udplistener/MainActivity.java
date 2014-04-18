package com.failingtofocus.udplistener.udplistener;

import android.app.Activity;
import android.os.Bundle;

public class UDPConnection extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);

        /* Kickoff the Server, it will
         * be 'listening' for one client packet */
        new Thread(new Server()).start();
        /* GIve the Server some time for startup */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) { }

        // Kickoff the Client
        new Thread(new Client()).start();
    }
}
