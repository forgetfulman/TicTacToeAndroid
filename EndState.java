package com.forgetfulman.tictactoe;

enum EndState {
    ROW2 (0b111000000),
    ROW1 (0b000111000),
    ROW0 (0b000000111),
    COL2 (0b100100100),
    COL1 (0b010010010),
    COL0 (0b001001001),
    DIAG (0b100010001),
    OPP_DIAG (0b001010100),
    DRAW (0b111111111);

    private final int endState;

    EndState(int state) {
        this.endState = state;
    }

    public int state() {
        return endState;
    }

}
