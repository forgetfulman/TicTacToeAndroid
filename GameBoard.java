package com.forgetfulman.tictactoe;

class GameBoard {

    private static int BOARD_ROWS = 3;
    private static int BOARD_COLS = 3;

    private int crossesState;
    private int noughtsState;
    //private Player currentPlayer;
    //private GameState currentGameState;

    GameBoard() {
        crossesState = 0b000000000;
        noughtsState = 0b000000000;
        /*currentPlayer = Player.CROSS;
        currentGameState = GameState.PLAYING;*/
    }

    /*GameState getCurrentGameState() {
        return this.currentGameState;
    }

    private void setCurrentGameState(GameState gs) {
        this.currentGameState = gs;
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }*/

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

    /*void makeMove(int x, int y) {
        int bitPosition = y * BOARD_ROWS + x;
        if (currentPlayer == Player.CROSS) {
            setPlayerState(crossesState | (0x1 << bitPosition), Player.CROSS);
        } else {
            setPlayerState(noughtsState | (0x1 << bitPosition), Player.NOUGHT);
        }
        setCurrentGameState(calculateGameState(currentPlayer));
    }*/

    void makeMove(int x, int y, Player p) {
        int bitPosition = y * BOARD_ROWS + x;
        if (p == Player.CROSS) {
            setPlayerState(crossesState | (0x1 << bitPosition), Player.CROSS);
        } else {
            setPlayerState(noughtsState | (0x1 << bitPosition), Player.NOUGHT);
        }
    }

    public int getBoardState() {
        return ((getPlayerState(Player.CROSS) | getPlayerState(Player.NOUGHT)));
    }

    /*void resetGame() {
        setPlayerState(0b000000000, Player.CROSS);
        setPlayerState(0b000000000, Player.NOUGHT);
        setCurrentPlayer(Player.CROSS);
        setCurrentGameState(GameState.PLAYING);
    }*/

    void resetGameBoard() {
        setPlayerState(0b000000000, Player.CROSS);
        setPlayerState(0b000000000, Player.NOUGHT);
    }

    /*private GameState calculateGameState(Player p) {
        int playerState = getPlayerState(Player.CROSS);
        if (getCurrentPlayer() == Player.CROSS) {
            setCurrentPlayer(Player.NOUGHT);
        } else {
            playerState = getPlayerState(Player.NOUGHT);
            setCurrentPlayer(Player.CROSS);
        }
        for (EndState e : EndState.values()) {
            if ((e.state() & playerState) == e.state()) {
                return (playerState == getPlayerState(Player.CROSS)) ? GameState.CROSS_WINS : GameState.NOUGHT_WINS;
            }
        }

        return ((getPlayerState(Player.CROSS) | getPlayerState(Player.NOUGHT)) == EndState.DRAW.state()) ? GameState.DRAW : GameState.PLAYING;
    }*/
}
