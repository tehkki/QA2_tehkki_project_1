package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS = By.xpath(".//a[contains(@class,'comment-count')]");

    private BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(HomePage.class);


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String  getTitleById(int id){
        List<WebElement> titles = baseFunc.findElements(TITLE);

        if (titles.size() < id)
            return null;

        return titles.get(id - 1).getText();
    }

    public void goToArticleById(int id) throws Exception {
        List<WebElement> titles = baseFunc.findElements(TITLE);
        if (titles.size() < id) {
            String msg = "Article with id " + id + " not found.";
            LOGGER.info(msg);

            throw new Exception(msg);
        }
        else
            baseFunc.click(titles.get(id - 1));
    }

    public int getCommentCount(int articleId) throws Exception {
        List<WebElement> comments = baseFunc.findElements(COMMENTS);
        if (comments.size() < articleId) {
            String msg = "Comments for article with id on home page" + articleId + " not found.";
            LOGGER.info(msg);

            throw new Exception(msg);
        }

        return baseFunc.getElementValueAsInt(comments.get(articleId-1));
    }
}
