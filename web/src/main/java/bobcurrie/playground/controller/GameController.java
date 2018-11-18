package bobcurrie.playground.controller;

import bobcurrie.playground.service.GameService;
import bobcurrie.playground.util.AttributeNames;
import bobcurrie.playground.util.GameMappings;
import bobcurrie.playground.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

    // == fields ==
    private final GameService gameService;

    @Autowired
    // == constructor ==
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // == request methods ==
    @GetMapping(GameMappings.PLAY)
    public String play(Model model) {
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model={}", model);

        if(gameService.isGameOver()) {
            return ViewNames.GAME_OVER;
        }

        return ViewNames.PLAY;

    }

    @PostMapping(GameMappings.PLAY)
    // Param must match name attribute inside input tag in form in play.html ie guess
    public String processMessage(@RequestParam int guess) {
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;

    }
}
