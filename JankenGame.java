import java.util.Random;
import java.util.Scanner;

public class JankenGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== じゃんけんゲーム ===");
        System.out.println("0: グー");
        System.out.println("1: チョキ");
        System.out.println("2: パー");

        while (true) {
            System.out.print("あなたの手を選んでください (0=グー, 1=チョキ, 2=パー, 9=終了): ");
            int player = scanner.nextInt();

            if (player == 9) {
                System.out.println("ゲームを終了します。ありがとうございました!");
                break;
            }

            if (player < 0 || player > 2) {
                System.out.println("0〜2の数字を入力してください。");
                continue;
            }

            int computer = random.nextInt(3);

            String[] hands = {"グー", "チョキ", "パー"};
            System.out.println("あなた: " + hands[player]);
            System.out.println("コンピュータ: " + hands[computer]);

            int result = judge(player, computer);
            if (result == 1) {
                System.out.println("あなたの勝ちです！");
            } else if (result == 0) {
                System.out.println("あいこです。");
            } else {
                System.out.println("あなたの負けです。");
            }

            System.out.println();
        }

        scanner.close();
    }

    // 1: player win, 0: draw, -1: player lose
    public static int judge(int player, int computer) {
        if (player == computer) {
            return 0;
        }

        if ((player == 0 && computer == 1) ||
            (player == 1 && computer == 2) ||
            (player == 2 && computer == 0)) {
            return 1;
        }

        return -1;
    }
}
