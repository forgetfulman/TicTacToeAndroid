package com.forgetfulman.tictactoe;

class Game {

    private Player currentPlayer;

    Game() {
        currentPlayer = Player.CROSS;
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }

    void resetGame() {
        setCurrentPlayer(Player.CROSS);
    }

    GameState calculateGameState(int playerState, int boardState) {
        for (EndState e : EndState.values()) {
            if ((e.state() & playerState) == e.state()) {
                return (getCurrentPlayer() == Player.CROSS) ? GameState.CROSS_WINS : GameState.NOUGHT_WINS;
            }
        }

        return (boardState == EndState.DRAW.state()) ? GameState.DRAW : GameState.PLAYING;
    }

}
