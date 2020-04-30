package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CommentsPage {

    private final BaseFunc baseFunc;
    private final By TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'type-cnt')]");

    public CommentsPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle(){
        return baseFunc.getElementContent(TITLE);
    }

    public int getCommentCount()
    {
        List<WebElement> commentElements = baseFunc.findElements(COMMENT_COUNT);

        if (commentElements.size() <= 0)
            return 0;

        int anonCommentCountInt = baseFunc.getElementValueAsInt(commentElements.get(0));
        int registeredCommentsCountInt = baseFunc.getElementValueAsInt(commentElements.get(1));

        return anonCommentCountInt + registeredCommentsCountInt;
    }
}
