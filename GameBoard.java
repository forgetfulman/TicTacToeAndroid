package com.forgetfulman.tictactoe;

class GameBoard {

    private static int BOARD_ROWS = 3;
    private static int BOARD_COLS = 3;

    private int crossesState;
    private int noughtsState;

    GameBoard() {
        crossesState = 0b000000000;
        noughtsState = 0b000000000;
    }

    int getPlayerState(Player p) {
        return (p == Player.CROSS) ? crossesState : noughtsState;
    }

    private void setPlayerState(int playerState, Player p) {
        if (p == Player.CROSS) {
            this.crossesState = playerState;
        } else {
            this.noughtsState = playerState;
        }
    }

    void makeMove(int x, int y, Player p) {
        int bitPosition = y * BOARD_ROWS + x;
        if (p == Player.CROSS) {
            setPlayerState(crossesState | (0x1 << bitPosition), Player.CROSS);
        } else {
            setPlayerState(noughtsState | (0x1 << bitPosition), Player.NOUGHT);
        }
    }

    int getBoardState() {
        return ((getPlayerState(Player.CROSS) | getPlayerState(Player.NOUGHT)));
    }

    void resetGameBoard() {
        setPlayerState(0b000000000, Player.CROSS);
        setPlayerState(0b000000000, Player.NOUGHT);
    }
}
