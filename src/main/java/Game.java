import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames = new ArrayList<Frame>();
    private int score = 0;

    public static void main(String[] args) throws BowlingException {

        Game game = new Game();

        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(5, 5));
        game.roll(new Frame(4, 4));

        game.score();

    }

    public void roll(Frame frame) {
        frames.add(frame);
        System.out.println(frames.toString());
    }

    public int score() {

        for (int i = 0; i < 10; i++) {

            int first = frames.get(i).getFirstRoll();
            int second = frames.get(i).getSecondRoll();

            //NOTHING
            if ((first + second) != 10) {
                score = score + first + second;
            }
            //SPARE
            else if (frames.get(i).isSpare()) {
                score = score + first + second + frames.get(i + 1).getFirstRoll();
            }
            //STRIKE
            else if (frames.get(i).isStrike()) {
                if (frames.get(i + 1).getFirstRoll() == 10) {
                    score = score + frames.get(i).getFirstRoll() + frames.get(i + 1).getFirstRoll() + frames.get(i + 2).getFirstRoll();
                } else {
                    score = score + frames.get(i).getFirstRoll() + frames.get(i + 1).getSum();
                }
            }
        }
        System.out.println(score);
        return score;
    }
}
