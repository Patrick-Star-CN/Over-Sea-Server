package team.over_sea.util;

import org.junit.jupiter.api.Test;
import org.languagetool.rules.RuleMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * @author Patrick_Star
 * @version 1.0
 */
@SpringBootTest
public class LanguageToolTest {
    @Autowired
    private LanguageTool languageTool;

    @Test
    public void check() throws IOException {
        String source = "A sentence with a error in the Hitchhiker's Guide tot he Galaxy";

        List<RuleMatch> matches = languageTool.check(source);
        for (RuleMatch match : matches) {
            System.out.println("Potential error at characters " +
                    match.getFromPos() + "-" + match.getToPos() + ": " +
                    match.getMessage());
            System.out.println("Suggested correction(s): " +
                    match.getSuggestedReplacements());
        }
    }
}
