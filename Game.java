package com.forgetfulman.tictactoe;

class Game {

    private Player currentPlayer;
    private GameStatus currentGameStatus;

    Game() {
        currentPlayer = Player.CROSS;
        currentGameStatus = GameStatus.PLAYING;
    }

    Player getCurrentPlayer() {
        return currentPlayer;
    }

    GameStatus getCurrentGameStatus() {
        return currentGameStatus;
    }

    void determineMoveOutcome(int playerState, int boardState) {
        setCurrentGameStatus(evaluateGameState(playerState, boardState));
    }

    private void setCurrentPlayer(Player p) {
        this.currentPlayer = p;
    }

    private void setCurrentGameStatus(GameStatus g) {
        this.currentGameStatus = g;
    }

    void resetGame() {
        setCurrentPlayer(Player.CROSS);
        setCurrentGameStatus(GameStatus.PLAYING);
    }

    private GameStatus evaluateGameState(int playerState, int boardState) {
        for (EndState e : EndState.values()) {
            if ((e.state() & playerState) == e.state()) {
                return (getCurrentPlayer() == Player.CROSS) ? GameStatus.CROSS_WINS : GameStatus.NOUGHT_WINS;
            }
        }
        return (boardState == EndState.DRAW.state()) ? GameStatus.DRAW : GameStatus.PLAYING;
    }

    void setNextPlayer() {
        setCurrentPlayer((getCurrentPlayer() == Player.CROSS) ? Player.NOUGHT : Player.CROSS);
    }

}
