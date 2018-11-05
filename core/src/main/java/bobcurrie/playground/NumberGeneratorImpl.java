package bobcurrie.playground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImpl implements NumberGenerator {

    // == fields ==
    private final Random random = new Random();

    private final int maxNumber;

    private final int minNumber;

    // == Constructor ==
    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber) + minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMinNumber() {
        return minNumber;
    }
}
