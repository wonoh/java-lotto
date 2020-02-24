package view;

import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    static{
        scanner = new Scanner(System.in);
    }

    public static int inputMoney(){
        System.out.println("금액을 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
    public static String inputWinningLotto(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
    public static String inputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextLine();
    }
}
