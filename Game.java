package com.forgetfulman.tictactoe;

class Game {

    private Player currentPlayer;
    private GameState currentGameState;

    Game() {
        currentPlayer = Player.CROSS;
        currentGameState = GameState.PLAYING;
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    GameState getCurrentGameState() {
        return currentGameState;
    }

    void updateGameState(int playerState, int boardState) {
        setCurrentGameState(determineGameState(playerState, boardState));
    }

    private void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }

    private void setCurrentGameState(GameState g) {
        this.currentGameState = g;
    }

    void resetGame() {
        setCurrentPlayer(Player.CROSS);
        setCurrentGameState(GameState.PLAYING);
    }

    private GameState determineGameState(int playerState, int boardState) {
        for (EndState e : EndState.values()) {
            if ((e.state() & playerState) == e.state()) {
                return (getCurrentPlayer() == Player.CROSS) ? GameState.CROSS_WINS : GameState.NOUGHT_WINS;
            }
        }
        return (boardState == EndState.DRAW.state()) ? GameState.DRAW : GameState.PLAYING;
    }

    void setNextPlayer() {
        setCurrentPlayer((getCurrentPlayer() == Player.CROSS) ? Player.NOUGHT : Player.CROSS);
    }

}
