package q15;

import java.util.HashMap;
import java.util.Map;

import q15.components.PageContent;

public class CoursePages {
    // Map representing the pages a course has
    private Map<String, PageContent> pageCollection = new HashMap<>();

    public Map<String, PageContent> getPages() {
        return pageCollection;
    }
}
