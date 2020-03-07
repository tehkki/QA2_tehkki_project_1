import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.util.List;
        import java.util.concurrent.TimeUnit;

public class Homework2 {
    private final By HOME_PAGE_ARTICLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By READ_COMMENTS_BUTTON = By.xpath(".//button[contains(@class,'input-read')]");
    private final By COMMENT_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'article-title')]");
    private final By HOME_PAGE_ARTICLE_COMMENTS = By.xpath(".//a[contains(@class,'comment-count')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'd-print-none')]");
    private final By COMMENT_COUNT = By.xpath(".//span[contains(@class, 'type-cnt')]");
    private final Logger LOGGER = LogManager.getLogger(Homework2.class);

    public WebDriver getTestDriver(){
        LOGGER.info("Loading Chromedriver");
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        LOGGER.info("Maximizing browser window");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        LOGGER.info("Opening rus.delfi.lv");
        driver.get("http://rus.delfi.lv");
        LOGGER.info("Wait 5 seconds");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void delfiArticleNamesTest(){
        WebDriver driver = getTestDriver();

        List<WebElement> secondArticleTitle = driver.findElements(HOME_PAGE_ARTICLE);
        LOGGER.info("Get title of second article on main page");
        String secondArticleTitleText = secondArticleTitle.get(1).getText();

        secondArticleTitle.get(1).click();
        WebElement articleTitle = driver.findElement(ARTICLE_PAGE_TITLE);
        LOGGER.info("Get article title on second article page");
        String articleTitleText = articleTitle.getText();

        WebElement articleCommentButton = driver.findElement(READ_COMMENTS_BUTTON);
        articleCommentButton.click();
        WebElement articleTitleCommentPage = driver.findElement(COMMENT_PAGE_TITLE);
        LOGGER.info("Get article title on comment page");
        String articleTitleCommentPageText = articleTitleCommentPage.getText();

        LOGGER.info("Comparing all article names");
        Assertions.assertEquals(secondArticleTitleText, articleTitleText, articleTitleCommentPageText);
    }

    @Test
    public void delfiCommentsCountTest(){
        WebDriver driver = getTestDriver();

        LOGGER.info("Get List of comments count for all articles on the main page");
        List<WebElement> secondArticleComments = driver.findElements(HOME_PAGE_ARTICLE_COMMENTS);
        LOGGER.info("Get second article comments count without brackets");
        String secondArticleCommentsCount = secondArticleComments.get(1).getText().replaceAll("\\D","");

        LOGGER.info("Convert second article comments count to int");
        int secondArticleCommentsCountToInt = Integer.parseInt(secondArticleCommentsCount);

        LOGGER.info("Second article comments on main page: " + secondArticleCommentsCountToInt);

        LOGGER.info("Going to second article page");
        List<WebElement> secondArticleTitles = driver.findElements(HOME_PAGE_ARTICLE);
        secondArticleTitles.get(1).click();

        LOGGER.info("Get this article comments count without brackets");
        WebElement articleTitleComments = driver.findElement(ARTICLE_PAGE_COMMENTS);
        String articleTitleCommentsCount = articleTitleComments.getText().replaceAll("\\D", "");
        LOGGER.info("Convert this article comments count to int");
        int articleTitleCommentsCountToInt = Integer.parseInt(articleTitleCommentsCount);

        LOGGER.info("Second article comments on article page: " + articleTitleCommentsCountToInt);

        LOGGER.info("Going to second article comment page");
        WebElement articleCommentButton = driver.findElement(ARTICLE_PAGE_COMMENTS);
        articleCommentButton.click();

        LOGGER.info("Get list of comment count");
        List<WebElement> articleCommentPageComments = driver.findElements(COMMENT_COUNT);

        LOGGER.info("Get anon comments count");
        String articleCommentPageAnonCommentsCount = articleCommentPageComments.get(0).getText().replaceAll("\\D", "");
        LOGGER.info("Get registered coments count");
        String articleCommentPageRegisteredCommentsCount = articleCommentPageComments.get(1).getText().replaceAll("\\D", "");
        LOGGER.info("Convert anon comments count to int");
        int articleCommentPageAnonCommentsCountToInt = Integer.parseInt(articleCommentPageAnonCommentsCount);
        LOGGER.info("Convert registered comments count to int");
        int articleCommentPageRegisteredCommentsCountToInt = Integer.parseInt(articleCommentPageRegisteredCommentsCount);

        LOGGER.info("Sum comments");
        int articleCommentPageCommentsTotalCount = articleCommentPageAnonCommentsCountToInt + articleCommentPageRegisteredCommentsCountToInt;

        LOGGER.info("Second article total comments count on comment page: " + articleCommentPageCommentsTotalCount);

        LOGGER.info("Comparing all article comments count");
        Assertions.assertEquals(secondArticleCommentsCountToInt, articleTitleCommentsCountToInt, articleCommentPageCommentsTotalCount);
    }
}
