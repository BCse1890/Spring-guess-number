package bobcurrie.playground;

public interface Game {
    int getNumber();
    int getGuess();
    void setGuess(int guess);
    int getSmallest();
    int getLargest();
    int getRemainingGuesses();
    int getGuessCount();
    void reset();
    void check();
    boolean isValidNumberRange();
    boolean isGameWon();
    boolean isGameLost();
}
