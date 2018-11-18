package bobcurrie.playground.service;

import bobcurrie.playground.Game;
import bobcurrie.playground.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    // == fields ==
    public final Game game;
    public final MessageGenerator messageGenerator;


    // == constants ==
    //private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == constructor
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == init ==
    @PostConstruct
    public void init() {
        log.info("number = {}, message = {}", game.getNumber(), messageGenerator.getMainMessage());
    }



    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
