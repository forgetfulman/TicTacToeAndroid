package com.forgetfulman.tictactoe;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by christoph on 22/01/2017.
 */

public class TicTacToeFragment extends Fragment implements View.OnClickListener {
    private GameBoard ticTacToeBoard;
    private Button restartButton;
    private TextView mStatusField;
    private Map<Integer,ToggleButton> buttons;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        ticTacToeBoard = new GameBoard();
        buttons = new HashMap<Integer,ToggleButton>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tictactoe, container, false);

        buttons.clear();
        buttons.put(1,(ToggleButton) v.findViewById(R.id.toggleButton));
        buttons.put(2,(ToggleButton) v.findViewById(R.id.toggleButton2));
        buttons.put(3,(ToggleButton) v.findViewById(R.id.toggleButton3));
        buttons.put(4,(ToggleButton) v.findViewById(R.id.toggleButton4));
        buttons.put(5,(ToggleButton) v.findViewById(R.id.toggleButton5));
        buttons.put(6,(ToggleButton) v.findViewById(R.id.toggleButton6));
        buttons.put(7,(ToggleButton) v.findViewById(R.id.toggleButton7));
        buttons.put(8,(ToggleButton) v.findViewById(R.id.toggleButton8));
        buttons.put(9,(ToggleButton) v.findViewById(R.id.toggleButton9));
        for (ToggleButton tb : buttons.values()) {
            tb.setOnClickListener(this);
            tb.setSaveEnabled(false);
        }
        mStatusField = (TextView) v.findViewById(R.id.gameStatus);
        mStatusField.setText(getGameStateDescription());
        restartButton = (Button) v.findViewById(R.id.restartButton);
        restartButton.setText("Restart Game");
        restartButton.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     ticTacToeBoard.resetGame();
                     for (ToggleButton tb : buttons.values()) {
                         tb.setText(" ");
                         tb.setEnabled(true);
                         tb.setChecked(false);
                     }
                     mStatusField.setText("Playing");
                 }
            }
        );

        return v;
    }

    @Override
    public void onClick(View v) {
        int x = 0;
        int y = 0;
        Button selectedButton = (Button) v.findViewById(v.getId());
        String playerMark = (ticTacToeBoard.getCurrentPlayer() == Player.CROSS) ? "X" : "O";
        switch (selectedButton.getId()) {

            case R.id.toggleButton:
                x = 0;
                y = 0;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton2:
                x = 1;
                y = 0;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton3:
                x = 2;
                y = 0;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton4:
                x = 0;
                y = 1;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton5:
                x = 1;
                y = 1;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton6:
                x = 2;
                y = 1;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton7:
                x = 0;
                y = 2;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton8:
                x = 1;
                y = 2;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            case R.id.toggleButton9:
                x = 2;
                y = 2;
                selectedButton.setText(playerMark);
                selectedButton.setEnabled(false);
                break;

            default:
                break;
        }

        ticTacToeBoard.makeMove(x,y);
        mStatusField.setText(getGameStateDescription());
        if (ticTacToeBoard.getCurrentGameState() != GameState.PLAYING) {
            for (ToggleButton tb : buttons.values()) {
                tb.setEnabled(false);
            }
        }
    }

    private String getGameStateDescription() {
        String stateDescription = "Not Playing";
        switch (ticTacToeBoard.getCurrentGameState()) {
            case PLAYING:
                stateDescription = "Playing";
                break;

            case DRAW:
                stateDescription = "It's a Draw!";
                break;

            case CROSS_WINS:
                stateDescription = "Crosses Win!";
                break;

            case NOUGHT_WINS:
                stateDescription = "Noughts Win!";
                break;

            default:
                break;
        }
        return stateDescription;
    }

    @Override
    public void onResume() {
        super.onResume();
        int j=1;
        for(int i=1; i<=ticTacToeBoard.getPlayerState(Player.CROSS); i<<=1) {
            ToggleButton tb = buttons.get(j++);
            if ((ticTacToeBoard.getPlayerState(Player.CROSS)&i) == i) {
                tb.setEnabled(false);
                tb.setText("X");
            }
        }
        j=1;
        for(int i=1; i<=ticTacToeBoard.getPlayerState(Player.NOUGHT); i<<=1) {
            ToggleButton tb = buttons.get(j++);
            if ((ticTacToeBoard.getPlayerState(Player.NOUGHT)&i) == i) {
                tb.setEnabled(false);
                tb.setText("0");
            }
        }
        if (ticTacToeBoard.getCurrentGameState() != GameState.PLAYING) {
            for (ToggleButton tb : buttons.values()) {
                tb.setEnabled(false);
            }
        }
    }
}
