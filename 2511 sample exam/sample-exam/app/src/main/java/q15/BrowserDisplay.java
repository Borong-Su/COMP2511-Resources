package q15;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Random;

import q15.components.*;
import q15.components.darkTheme.*;
import q15.components.lightTheme.*;

public class BrowserDisplay {
    private PermissionLevel currentPerms;
    private String currentTheme;

    private HeaderBar header;
    private NavSidePanel sidePanel;
    private PageContainer pageContainer;
    private String backgroundColour;

    /**
     * Sets the default clock to the system time
     * This is used for testing, do not modify this line
     */
    private Clock clock = Clock.systemDefaultZone();

    public BrowserDisplay(String theme, PermissionLevel perms) {
        this.currentPerms = perms;
        initializeTheme(theme);
        generateTheme();
    }

    private void initializeTheme(String theme) {
        currentTheme = theme;
    }

    private void generateTheme() {
        if (currentTheme.equals("light")) {
            header = new LightHeader();
            sidePanel = new LightSidePanel();
            if (LocalDateTime.now(clock).getHour() >= 0 && LocalDateTime.now(clock).getHour() < 4) {
                pageContainer = new DarkPageContainer(currentPerms.equals(PermissionLevel.ADMIN), new PageContent());
                backgroundColour = "black";
            } else {
                pageContainer = new LightPageContainer(currentPerms.equals(PermissionLevel.ADMIN), new PageContent());
                backgroundColour = "white";
            }
        } else if (currentTheme.equals("dark")) {
            header = new DarkHeader();
            sidePanel = new DarkSidePanel();
            pageContainer = new DarkPageContainer(currentPerms.equals(PermissionLevel.ADMIN), new PageContent());
            backgroundColour = "black";
        } else if (currentTheme.equals("random")) {
            Random random = new Random();
            header = random.nextBoolean() ? new LightHeader() : new DarkHeader();
            sidePanel = random.nextBoolean() ? new LightSidePanel() : new DarkSidePanel();
            pageContainer = random.nextBoolean()
                    ? new LightPageContainer(currentPerms.equals(PermissionLevel.ADMIN), new PageContent())
                    : new DarkPageContainer(currentPerms.equals(PermissionLevel.ADMIN), new PageContent());

            if (pageContainer instanceof LightPageContainer) {
                backgroundColour = "white";
            } else {
                backgroundColour = "black";
            }
        }
    }

    public void changePage(PageContent newPage) {
        pageContainer.setContent(newPage);
        pageContainer.updateHistory();
    }

    public String render() {
        return "Background colour: " + backgroundColour + "\nHeader: " + header.render() + "SidePanel: "
                + sidePanel.render() + "PageContainer: " + pageContainer.render();
    }

    public String renderPage() {
        return "PageContainer: " + pageContainer.render();
    }

    public void goBack() {
        pageContainer.goBack();
    }

    public void wipeHistory() {
        pageContainer.clearHistory();
    }

    public void setClock(Clock clock) {
        this.clock = clock;
        generateTheme();
    }
}
