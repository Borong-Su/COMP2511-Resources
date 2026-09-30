package q15.components.darkTheme;

import java.util.ArrayList;
import java.util.List;

import q15.components.PageContainer;
import q15.components.PageContent;

public class DarkPageContainer implements PageContainer {
    private boolean isAdmin;
    private PageContent content;
    private List<PageContent> history = new ArrayList<>();

    public DarkPageContainer(boolean isAdmin, PageContent content) {
        this.isAdmin = isAdmin;
        this.content = content;
    }

    public String render() {
        return "Rendering a dark theme page titled " + content.getPageName() + " with body " + content.getBodyText()
                + "\n";
    }

    public void setContent(PageContent content) {
        this.content = content;
    }

    public void updateHistory() {
        history.add(content);
    }

    public void clearHistory() {
        if (isAdmin) {
            history.clear();
        } else {
            throw new RuntimeException("Insufficient privileges");
        }
    }

    public void goBack() {
        if (history.size() > 1) {
            history.remove(history.size() - 1);
            this.content = history.get(history.size() - 1);
        }
    }
}
