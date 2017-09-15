package FootBallTeam;

/**
 * Created by jotishsuthar on 15/09/17.
 */
public class FootBallTeam implements Comparable{
    public int getNoOfGamesWon() {
        return mNoOfGamesWon;
    }

    private  int mNoOfGamesWon;
    public FootBallTeam(int noOfGamesWon) {
        if (noOfGamesWon < 0) {
            throw new IllegalArgumentException("No. of games should be positive");
        }
        mNoOfGamesWon = noOfGamesWon;
    }


    @Override
    public int compareTo(Object otherTeam) {
        if (!(otherTeam instanceof FootBallTeam)){
            throw new IllegalArgumentException(
                    "OtherTeam should be instace of " + FootBallTeam.class.getSimpleName());
        }
        return mNoOfGamesWon - ((FootBallTeam)otherTeam).getNoOfGamesWon();
    }
}
