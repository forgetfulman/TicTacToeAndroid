package com.forgetfulman.tictactoe;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Parcelable;

public class TicTacToeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);

        FragmentManager fm = getFragmentManager();
        Fragment ticTacToeFragment = fm.findFragmentById(R.id.fragmentContainer);

        if (ticTacToeFragment == null) {
            ticTacToeFragment = new TicTacToeFragment();
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, ticTacToeFragment)
                    .commit();
        }
    }

}
