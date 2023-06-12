package util.generator;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate(int minNumber, int maxNumber) {
        return (int) ((Math.random() * (maxNumber - minNumber + 1)) + minNumber);
    }
}
