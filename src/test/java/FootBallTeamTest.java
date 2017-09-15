import FootBallTeam.FootBallTeam;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junitparams.JUnitParamsRunner.$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jotishsuthar on 15/09/17.
 */
@RunWith(JUnitParamsRunner.class)
public class FootBallTeamTest {

    public static final int ANY_NUMBER = 123;
    public Object[] nbOfGamesWon() {
        return $(0, 1, 2);
    }

    public Object[] illegalNoOfGamesWoen(){
        return $(-1,-2,-3);
    }


    @Test
    @Parameters(method = "nbOfGamesWon")
    public void constructorShouldSetGamesWon(int noOfGamesWon){
        FootBallTeam team = new FootBallTeam(noOfGamesWon);
        assertEquals(noOfGamesWon + " games passed but " + team.getNoOfGamesWon() + " were returned",
                noOfGamesWon, team.getNoOfGamesWon());
    }


    @Test(expected = IllegalArgumentException.class)
    @Parameters(method="illegalNoOfGamesWoen")
    public void constructorShouldThrowExceptionForIllegalGamesNb(int noOfGamesWon){
        new FootBallTeam(noOfGamesWon);
    }

    @Test
    public void shouldBeComparable(){
        FootBallTeam team = new FootBallTeam(ANY_NUMBER);
        assertTrue("Football team should be of type Comparable", team instanceof Comparable);
    }

    @Test
    public void teamsWithMoreMatchesWonShouldBeGreater(){
        FootBallTeam team_2 = new FootBallTeam(2);
        FootBallTeam team_3 = new FootBallTeam(3);
        assertTrue("Team with more goals should be ranked higher", team_3.compareTo(team_2) > 0);
    }

    @Test
    public void teamsWithLessMatchesWonShouldBeLesser(){
        FootBallTeam team_2 = new FootBallTeam(2);
        FootBallTeam team_3 = new FootBallTeam(3);
        assertTrue("Team with more goals should be ranked higher", team_2.compareTo(team_3) < 0);

    }

    @Test
    public void teamsWithEqualMatchesWonShouldBeEqual(){
        FootBallTeam team_2 = new FootBallTeam(2);
        FootBallTeam team_x = new FootBallTeam(2);
        assertTrue("Team with more goals should be ranked higher", team_2.compareTo(team_x) == 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void footBallTeamShouldThrowExpectionOnComparingWithRandomClass(){
        FootBallTeam team = new FootBallTeam(1);
        Object randomObject = new Object();
        team.compareTo(randomObject);
    }
}
