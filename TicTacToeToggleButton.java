package com.forgetfulman.tictactoe;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ToggleButton;

public class TicTacToeToggleButton extends ToggleButton {

    private int x_coord;
    private int y_coord;

    public int getX_coord() {
        return x_coord;
    }

    public void setX_coord(int x_coord) {
        this.x_coord = x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public void setY_coord(int y_coord) {
        this.y_coord = y_coord;
    }

    public TicTacToeToggleButton(Context context) {
        super(context);
    }

    public TicTacToeToggleButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.TicTacToeToggleButton);
        setX_coord(Integer.parseInt(arr.getString(R.styleable.TicTacToeToggleButton_x_coord)));
        setY_coord(Integer.parseInt(arr.getString(R.styleable.TicTacToeToggleButton_y_coord)));
        arr.recycle();
    }

    public TicTacToeToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray arr = context.obtainStyledAttributes(attrs, R.styleable.TicTacToeToggleButton);
        setX_coord(Integer.parseInt(arr.getString(R.styleable.TicTacToeToggleButton_x_coord)));
        setY_coord(Integer.parseInt(arr.getString(R.styleable.TicTacToeToggleButton_y_coord)));
        arr.recycle();
    }
}
