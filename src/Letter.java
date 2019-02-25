import java.util.Scanner;

public class Letter {

    char c;
    int score;

    int x;
    int y;



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
}
