import java.util.Scanner;

public class Letter {

    char c;

    int score;

    Letter(String str){

        Scanner sc = new Scanner(str);

        c = sc.next().charAt(0);

        score = Integer.parseInt(sc.next());

    }
}
