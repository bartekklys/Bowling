import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class Tests {

    @Test
    public void shouldReturn20AfterHit20TimesOnePin(){
        //given
        Game game = new Game();
        int expectedScore = 20;
        //when
        for(int i = 0 ; i < 20 ; i++) {
            game.roll(1);
        }
        int result = game.score();
        //then
        assertThat(result).isEqualTo(expectedScore);
    }
}
