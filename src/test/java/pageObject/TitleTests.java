package pageObject;

        import org.apache.logging.log4j.LogManager;
        import org.apache.logging.log4j.Logger;
        import org.junit.jupiter.api.Assertions;
        import org.junit.jupiter.api.Test;

public class TitleTests {
    private BaseFunc baseFunc = new BaseFunc();
    private final Logger LOGGER = LogManager.getLogger(TitleTests.class);

    @Test
    public void titleCheck() throws Exception {
        baseFunc.openHomePage();
        int articleId = 2;

        HomePage homePage = new HomePage(baseFunc);
        String homePageTitle = homePage.getTitleById(articleId);
        int homePageCommentCount = homePage.getCommentCount(articleId);
        LOGGER.info("Title of " + articleId + " article on home page: " + homePageTitle);
        homePage.goToArticleById(articleId);

        ArticlePage articlePage = new ArticlePage(baseFunc);
        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentCount = articlePage.getCommentCount();
        LOGGER.info("Title of " + articleId + " article on article page: " + articlePageTitle);
        articlePage.goToCommentsPage();

        CommentsPage commentsPage = new CommentsPage(baseFunc);
        String commentsPageTitle = commentsPage.getTitle();
        int commentPageCommentCount = commentsPage.getCommentCount();
        LOGGER.info("Title of " + articleId + " article on comments page: " + commentsPageTitle);

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Article page title is not equal");
        Assertions.assertEquals(homePageTitle, commentsPageTitle, "Comment page title is not equals");

        Assertions.assertEquals(homePageCommentCount, articlePageCommentCount, "Article page comment count is not equal");
        Assertions.assertEquals(homePageCommentCount, commentPageCommentCount, "Comment page comment count is not equals");
    }
}
