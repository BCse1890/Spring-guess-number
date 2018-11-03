package bobcurrie.playground.config;

import bobcurrie.playground.GuessCount;
import bobcurrie.playground.MaxNumber;
import bobcurrie.playground.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
public class GameConfig {

    // == fields ==
    @Value("${game.maxNumber: 20}")
    private int maxNumber;

    @Value("${game.minNumber: 5}")
    private int minNumber;

    @Value("${game.guessCount: 5}")
    private int guessCount;

    // == bean methods ==
    @Bean
    @MaxNumber
    public int maxNumber() {
        return maxNumber;
    }

    @Bean
    @MinNumber
    public int minNumber() {
        return minNumber;
    }

    @Bean
    @GuessCount
    public int guessCount() {
        return guessCount;
    }
}
