
public class TennisGame1 implements TennisGame {

    private int score1 = 0;
    private int score2 = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            score1 += 1;
        else
            score2 += 1;
    }

    public String getScore() {
        String score;
        if (score1 == score2) {
            score = validateEquals();
        } else if (score1 >= 4 || score2 >= 4) {
            score = validateEndPoint();
        } else {
            score = validatePlayingPoint();
        }
        return score;
    }

    private String validatePlayingPoint() {
        String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return points[score1] + "-" + points[score2];
    }

    private String validateEndPoint() {
        int minusResult = score1 - score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        return minusResult >= 2 ? "Win for player1" : "Win for player2";

    }

    private String validateEquals() {
        String[] points = new String[]{"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
        return score1 >= 3 ? "Deuce" : points[score1];
    }
}
