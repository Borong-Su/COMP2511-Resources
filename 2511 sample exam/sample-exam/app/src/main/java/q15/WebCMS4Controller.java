package q15;

import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

import q15.components.PageContent;

public class WebCMS4Controller {
    // Component that displays all of WebCMS4 to the user.
    private BrowserDisplay browserDisplay;
    private PermissionLevel perms;

    // List of courses on WebCMS4
    private List<Course> courses = new ArrayList<>();

    public WebCMS4Controller(PermissionLevel perms, String theme) {
        this.perms = perms;
        this.browserDisplay = new BrowserDisplay(theme, perms);
    }

    private Course findCourse(String id) {
        for (Course course : courses) {
            if (course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Create a new course on WebCMS4
     * @param id String: The id of the course e.g. COMP2511
     * @param term String: The year and term of the course offering e.g. 24T3
     * @param lecturer String: The name and title of the lecturer e.g. Dr Ashesh Mahidadia
     */
    public void createCourse(String id, String term, String lecturer) {
        courses.add(new Course(id, term, lecturer));
    }

    /**
     * Get the information of a specific course
     * @param courseId
     * @return String representing a course's information with the format id / term / lecturer / page count
     */
    public String getCourseInfo(String courseId) {
        return findCourse(courseId).getInfo();
    }

    /**
     * Adds a new page to a course
     * @param courseId The id of the course
     * @param page The page to be added
     */
    public void addPage(String courseId, PageContent page) {
        findCourse(courseId).addPage(page);
    }

    /**
     * Switch which page is being displayed
     * @param courseId The id of the course whose page is to be displayed
     * @param pageName The name of the page to be displayed. Will always be a valid page in the course.
     */
    public void changePage(String courseId, String pageName) {
        browserDisplay.changePage(findCourse(courseId).getPage(pageName));
    }

    /**
     * Go back to the previous page
     * If there was no previous page, do nothing
     */
    public void navigateBack() {
        browserDisplay.goBack();
    }

    /**
     * Resets all history from the browser
     */
    public void resetHistory() {
        browserDisplay.wipeHistory();
    }

    /**
     * Attempts to edit a page
     * @param courseId The id of the course whose page is to be edited
     * @param pageName The name of the page to be edited. Will always be a valid page in the course.
     * @param newContent
     */
    public void editPage(String courseId, String pageName, String newContent) {
        findCourse(courseId).editPage(pageName, newContent, perms);
        changePage(courseId, pageName);
    }

    /**
     * Renders all elements on the page
     * @return a String representing all rendered elements
     */
    public String render() {
        return browserDisplay.render();
    }

    /**
     * Renders just the page
     * @return a String representing the rendered page
     */
    public String renderPage() {
        return browserDisplay.renderPage();
    }

    /**
     * Updates the clock used by the system.
     * Used for testing - DO NOT DELETE
     * @param c The clock to be updated
     */
    public void setClock(Clock c) {
        browserDisplay.setClock(c);
    }
}
