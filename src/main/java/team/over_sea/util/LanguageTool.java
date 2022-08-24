package team.over_sea.util;

import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@Component
public class LanguageTool {

    private JLanguageTool langTool = new JLanguageTool(new BritishEnglish());

    public List<RuleMatch> check(String source) throws IOException {
        return langTool.check(source);
    }
}
