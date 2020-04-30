import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TVNetTest {

    private final Logger LOGGER = LogManager.getLogger(TVNetTest.class);
    private final By ALL_ARTICLES = By.tagName("article");
    private final By ARTICLE_TITLE_LINK = By.xpath(".//a[@class='list-article__media']");
    private final By ARTICLE_TITLE = By.xpath(".//span[@class='list-article__headline']");
    private final By ARTICLE_COMMENTS = By.xpath(".//span[contains(@class,'list-article__comment')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class,'article-headline')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//span[contains(@class,'article-share__item')]");
    private final By ARTICLE_PAGE_COMMENTS_LINK = By.xpath(".//a[contains(@class,'article-share__item--comments')]");
    private final By COMMENT_PAGE_COMMENTS = By.xpath(".//span[contains(@class,'article-comments-heading__count')]");

    @Test
    public void tvNetArticleTest() {
        LOGGER.info("Loading Chromedriver");
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LOGGER.info("Maximize window");
        driver.manage().window().maximize();
        driver.get("http://rus.tvnet.lv");

        LOGGER.info("Wait for element to be clickable");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ALL_ARTICLES));

        LOGGER.info("Get list of all articles");
        List<WebElement> articles = driver.findElements(ALL_ARTICLES);
        WebElement secondArticle = articles.get(1);

        LOGGER.info("Get 2nd article title text");
        String secondArticleText = secondArticle.findElement(ARTICLE_TITLE).getText();

        LOGGER.info("Get 2nd article comment count");
        List<WebElement> articleComments = secondArticle.findElements(ARTICLE_COMMENTS);

        String commentCount = "0";
        if (articleComments.size() != 0) {
            commentCount = articleComments.get(0).getText().replaceAll("[^0-9]", "");
        }

        LOGGER.info("Comment count on article: " + commentCount);

        LOGGER.info("Going to 2nd article page");
        WebElement articlePageLink = secondArticle.findElement(ARTICLE_TITLE_LINK);
        articlePageLink.click();

        LOGGER.info("Get this article title text");
        WebElement articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        String articlePageTitleText = articlePageTitle.getText();

        LOGGER.info("Get this article comments count");
        WebElement commentPagelink = driver.findElement(ARTICLE_PAGE_COMMENTS_LINK);
        List<WebElement> articlePageComments = commentPagelink.findElements(ARTICLE_PAGE_COMMENTS);

        String thisArticleCommentsCount = "0";
        if (articlePageComments.size() != 0) {
            WebElement articlePageCommentsCount = articlePageComments.get(0);
            thisArticleCommentsCount = articlePageCommentsCount.getText().replaceAll("[^0-9]", "");
        }

        LOGGER.info("Going to this article comment page");
        commentPagelink.click();

        LOGGER.info("Get 2nd article title text on comment page");
        WebElement commentPageArticleTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        String commentPageArticleTitleText = commentPageArticleTitle.getText();

        LOGGER.info("Get 2nd article comments count on comment page");
        List<WebElement> commentPageComments = driver.findElements(COMMENT_PAGE_COMMENTS);

        String commentPageCommentsCount = "0";
        if (commentPageComments.size() != 0) {
            WebElement commentPageCommentsElement = commentPageComments.get(0);
            commentPageCommentsCount = commentPageCommentsElement.getText().replaceAll("[^0-9]", "");
        }

        LOGGER.info("Comparing article names on all pages");
        Assertions.assertEquals(secondArticleText, articlePageTitleText, commentPageArticleTitleText);

        LOGGER.info("Comparing comment count on all pages");
        Assertions.assertEquals(commentCount, thisArticleCommentsCount, commentPageCommentsCount);
    }


}
