package q15.components;

public class PageContent {
    private String pageName;
    private String bodyText;

    public PageContent() {
        this.pageName = "Welcome to your new site";
        this.bodyText = "Why don't you try adding some new pages?";
    }

    public PageContent(String pageName, String bodyText) {
        this.pageName = pageName;
        this.bodyText = bodyText;
    }

    public String getPageName() {
        return pageName;
    }

    public String getBodyText() {
        return bodyText;
    }

    public void edit(String newBodyText) {
        bodyText = newBodyText;
    }
}
