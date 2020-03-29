import lotto.domain.*;
import lotto.web.CustomTemplateEngine;
import spark.ModelAndView;
import spark.utils.StringUtils;

import java.util.*;

import static spark.Spark.*;

public class Main {

    private static final String STATIC_FILE_LOCATION = "/templates";
    public static String render(Map<String,Object> model,String templatePath){
        return new CustomTemplateEngine(STATIC_FILE_LOCATION).render(new ModelAndView(model,templatePath));
    }
    public static void main(String[] args){
        staticFiles.location(STATIC_FILE_LOCATION);
        port(8080);

        get("/", (req, res) -> "index");
        post("/buyLotto",(req,res) ->{
            final int inputMoney = Integer.parseInt(req.queryParams("inputMoney"));
            Money money = Money.of(inputMoney);

            final String manualNumber = req.queryParams("manualNumber");
            List<String> inputManualLottos = new ArrayList<>();
            if(!StringUtils.isEmpty(manualNumber)){
                Collections.addAll(inputManualLottos, manualNumber.split("\n"));
            }

            LottoStore lottoStore = LottoGenerator.generateLottoStore(money,inputManualLottos);

            req.session().attribute("lottoStore",lottoStore);

            Map<String,Object> model = new HashMap<>();
            model.put("lottoStore",lottoStore);
            return render(model,"show.html");
        });
        post("/matchLotto",(req,res) ->{
            final String winningNumber = req.queryParams("winningNumber");
            final int bonusNumber = Integer.parseInt(req.queryParams("bonusNumber"));
            WinningLotto winningLotto = WinningLotto.of(winningNumber,bonusNumber);

            LottoStore lottoStore = req.session().attribute("lottoStore");

            Results results = lottoStore.createResults(winningLotto);

            Map<String,Object> model = new HashMap<>();
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
