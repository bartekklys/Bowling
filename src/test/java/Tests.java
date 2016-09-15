import exception.BowlingException;
import game.Frame;
import game.Game;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Tests {

    private Game game;



    @BeforeMethod
    public void setUp(){
        game = new Game();
    }

    @Test
    public void constructorShouldSetAmountAndCurrency() throws BowlingException {
        //given
        Frame frame = new Frame(4, 3);
        int expectedFirstRoll = 4;
        int expectedSecondRoll = 3;
        //then
        assertThat(frame.getFirstRoll()).isEqualTo(expectedFirstRoll);
        assertThat(frame.getSecondRoll()).isEqualTo(expectedSecondRoll);
    }

    @Test
    public void shouldReturn40AfterRolling10TimesFor2Points() throws BowlingException {
        //given
        int expectedResult = 40;
        //when
        for(int i = 0 ; i < 10 ; i++) {
            game.roll(new Frame(2,2));
        }
        //then
        assertThat(game.score()).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnCorrectScore() throws BowlingException {
        //given
        int expectedResult = 142;
        //when
        for(int i = 0 ; i < 9 ; i++) {
            game.roll(new Frame(5, 5));
        }
        game.roll(new Frame(4, 4));
        //then
        assertThat(game.score()).isEqualTo(expectedResult);
    }

    @Test(expectedExceptions = BowlingException.class)
    public void shouldThrowBowlingExceptionWhenNumberOfPinsIsGreaterThan10() throws BowlingException {
        //given
        Frame frame = new Frame(11,0);
    }

    @Test
    public void shouldReturn300() throws BowlingException {
        //given
        int expectedResult = 50;
        //when
        game.roll(new Frame(10, 0));
        for(int i = 0 ; i < 9 ; i++) {
            game.roll(new Frame(2, 2));
        }
        //then
        assertThat(game.score()).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturn0AfterFailingAllRolls() throws BowlingException {
        //given
        int expectedResult = 0;
        //when
        for(int i = 0 ; i < 10 ; i++) {
            game.roll(new Frame(0, 0));
        }
        //then
        assertThat(game.score()).isEqualTo(expectedResult);
    }

    @Test
    public void shouldReturnCorrectScoreAfterRollingManyStrikesInRow() throws BowlingException {
        //given
        int expectedResult = 224;
        //when
        for(int i = 0 ; i < 8 ; i++) {
            game.roll(new Frame(10, 0));
        }
        game.roll(new Frame(2, 2));
        game.roll(new Frame(2, 2));
        //then
        assertThat(game.score()).isEqualTo(expectedResult);
    }

}
