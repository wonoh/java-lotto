import lotto.domain.*;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import spark.utils.StringUtils;

import java.util.*;

import static spark.Spark.*;

public class Main {
    private static LottoStore lottoStore;
    public static String render(Map<String,Object> model,String templatePath){
        return new HandlebarsTemplateEngine().render(new ModelAndView(model,templatePath));
    }
    public static void main(String[] args){
        staticFiles.location("/templates/");
        port(8080);

        get("/", (req, res) -> "index");
        post("/buyLotto",(req,res) ->{
            Map<String,Object> model = new HashMap<>();
            final int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            Money money = Money.of(inputMoney);
            final String manualNumber = req.queryParams("manualNumber");
            System.out.println(manualNumber);
            List<String> inputManualLottos = new ArrayList<>();
            if(!StringUtils.isEmpty(manualNumber)){
                Collections.addAll(inputManualLottos, manualNumber.split("\n"));
            }
            lottoStore = LottoGenerator.generateLottoStore(money,inputManualLottos);
            model.put("lottoStore",lottoStore);
            return render(model,"show.html");
        });
        post("/matchLotto",(req,res) ->{
            Map<String,Object> model = new HashMap<>();
            final String winningNumber = req.queryParams("winningNumber");
            final int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));
            WinningLotto winningLotto = WinningLotto.of(winningNumber,bonusNumber);
            Results results = lottoStore.createResults(winningLotto);
            model.put("results",results.getResults());
            model.put("yield",results.getYield());
            return render(model,"result.html");
        });

       /* Money money = Money.of(InputView.inputMoney());
        int manualLottoCount = InputView.inputManualLottoCount();
        List<String> inputManualLotts = InputView.inputManualLottoNumbers(manualLottoCount);

        LottoStore lottoStore = LottoGenerator.generateLottoStore(money,inputManualLotts);
        ResultView.printLotto(lottoStore);

        String inputWinningNumber = InputView.inputWinningLotto();
        int inputBonusNumber = InputView.inputBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(inputWinningNumber,inputBonusNumber);
        Results results = lottoStore.createResults(winningLotto);
        ResultView.printResults(results);*/
    }
}
