package q15;

import q15.components.PageContent;

public class Course {
    private String id;
    private String term;
    private String lecturer;

    private CoursePages pages; // The pages a course has

    public Course(String id, String term, String lecturer) {
        this.id = id;
        this.term = term;
        this.lecturer = lecturer;
        pages = new CoursePages();
    }

    public void addPage(PageContent page) {
        pages.getPages().put(page.getPageName(), page);
    }

    public void editPage(String page, String newContent, PermissionLevel perms) {
        if (!perms.equals(PermissionLevel.ADMIN)) {
            throw new RuntimeException("Insufficient permissions");
        }
        getPage(page).edit(newContent);
    }

    public PageContent getPage(String pagename) {
        return pages.getPages().get(pagename);
    }

    public String getInfo() {
        return id + " / " + term + " / " + lecturer + " / " + pages.getPages().size();
    }

    public String getId() {
        return id;
    }
}
