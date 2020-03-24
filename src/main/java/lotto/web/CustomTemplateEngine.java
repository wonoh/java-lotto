package lotto.web;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import spark.template.handlebars.HandlebarsTemplateEngine;

public class CustomTemplateEngine extends HandlebarsTemplateEngine {
    public CustomTemplateEngine(String resourceRoot) {
        TemplateLoader templateLoader = new ClassPathTemplateLoader();
        templateLoader.setPrefix(resourceRoot);
        templateLoader.setSuffix(null);

        handlebars = new Handlebars(templateLoader);
        handlebars.registerHelper("inc", (Helper<Integer>) (context, options) -> context+1);
    }
    @Override
    public String render(Object object) {
        return super.render(object);
    }
}
