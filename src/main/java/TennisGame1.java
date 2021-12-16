import java.util.List;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score;
        if (m_score1 == m_score2) {
            score = validateEquals();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = validateEndPoint();
        } else {
            score = validatePlayingPoint();
        }
        return score;
    }

    private String validatePlayingPoint() {
        String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        return points[m_score1] + "-" + points[m_score2];
    }

    private String validateEndPoint() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        return minusResult >= 2 ? "Win for player1" : "Win for player2";

    }

    private String validateEquals() {
        String[] points = new String[]{"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
        return m_score1 >= 3 ? "Deuce" : points[m_score1];
    }
}
