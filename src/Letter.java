import java.util.Scanner;

public class Letter {

    private char c;
    private int score;

    Letter(char c, int score){
        this.c = c;
        this.score = score;
    }

    Letter(String str){

        System.out.println(str);

        Scanner sc = new Scanner(str);

        c = sc.next().charAt(0);

        score = Integer.parseInt(sc.next());
        sc.close();

    }

    public char getChar() {
        return c;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return c + "(" + score + ")";
    }
}
