package q15.components;

public interface PageContainer {
    public String render();

    public void setContent(PageContent content);

    public void updateHistory();

    public void clearHistory();

    public void goBack();

}
