package pageObject;

        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebElement;

public class ArticlePage {
    private final By TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS = By.xpath(".//a[contains(@class, 'd-print-none')]");

    private BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(ArticlePage.class);

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.getElementContent(TITLE);
    }

    public void goToCommentsPage() throws Exception {
        WebElement commentLink = baseFunc.findElement(COMMENTS);

        if (commentLink == null) {
            String msg = "Comment link from article page not found.";
            LOGGER.info(msg);
            throw new Exception(msg);
        }

        baseFunc.click(commentLink);
    }

    public int getCommentCount() {
        WebElement commentLink = baseFunc.findElement(COMMENTS);
        if (commentLink == null)
            return 0;

        return baseFunc.getElementValueAsInt(commentLink);
    }
}
