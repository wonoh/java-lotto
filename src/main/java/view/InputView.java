package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    public static int inputManualLottoCount(){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }
    public static List<String> inputManualLottoNumbers(int manualLottoCount){
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        scanner.nextLine();
        return IntStream.range(0,manualLottoCount)
                .mapToObj(i->scanner.nextLine())
                .collect(Collectors.toList());
    }
    public static int inputBonusNumber(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
