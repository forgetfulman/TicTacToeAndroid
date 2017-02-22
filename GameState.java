package com.forgetfulman.tictactoe;

enum GameState {
    PLAYING (R.string.game_state_playing),
    DRAW (R.string.game_state_draw),
    CROSS_WINS (R.string.game_state_crosses),
    NOUGHT_WINS (R.string.game_state_noughts);

    private final int descriptionId;

    GameState(int description) {
        this.descriptionId = description;
    }

    public int description() {
        return descriptionId;
    }
}
