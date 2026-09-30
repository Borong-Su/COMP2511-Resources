package q15;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

import q15.PermissionLevel;
import q15.WebCMS4Controller;
import q15.components.PageContent;

public class WebCMS4Test {
    @Test
    public void LightThemeDayTest() {
        WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.TUTOR, "light");

        // Force-set the WebCMS4 clock to 10am time on some day
        controller.setClock(
                Clock.fixed(Instant.parse("2024-11-19T10:00:00Z"), ZoneId.of("UTC")));

        controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");
        controller.addPage("COMP2511", new PageContent("Course Outline", "Course outline content"));
        controller.changePage("COMP2511", "Course Outline");

        String expected = "Background colour: white\n" +
                "Header: Rendering a light theme header\n" +
                "SidePanel: Rendering a light theme side panel\n" +
                "PageContainer: Rendering a light theme page titled Course Outline with body Course outline content\n";

        assertEquals(expected, controller.render());

    }

    @Test
    public void LightThemeNightTest() {
        WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.TUTOR, "light");

        // Force-set the WebCMS4 clock to 1am time on some day
        controller.setClock(Clock.fixed(Instant.parse("2024-11-19T01:00:00Z"), ZoneId.of("UTC")));

        controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");
        controller.addPage("COMP2511",
                new PageContent("Lecture Schedule", "Lecture schedule information here"));
        controller.changePage("COMP2511", "Lecture Schedule");

        String expected = "Background colour: black\n" +
                "Header: Rendering a light theme header\n" +
                "SidePanel: Rendering a light theme side panel\n" +
                "PageContainer: Rendering a dark theme page titled Lecture Schedule with body Lecture schedule information here\n";

        assertEquals(expected, controller.render());
    }

    @Test
    public void DarkThemeTest() {
        WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.TUTOR, "dark");

        controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");
        controller.addPage("COMP2511",
                new PageContent("Setup Guide", "Have you tried cleaning your Java Environment?"));
        controller.changePage("COMP2511", "Setup Guide");

        String expected = "Background colour: black\n" +
                "Header: Rendering a dark theme header\n" +
                "SidePanel: Rendering a dark theme side panel\n" +
                "PageContainer: Rendering a dark theme page titled Setup Guide with body Have you tried cleaning your Java Environment?\n";

        assertEquals(expected, controller.render());
    }

    @Test
    public void RandomThemeTest() {
        boolean seenDark = false;
        boolean seenLight = false;

        // Since it's 50/50, should probably see both dark and light in 100 tries
        for (int i = 0; i < 100; i++) {
            WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.TUTOR, "random");

            controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");
            controller.addPage("COMP2511",
                    new PageContent("Tutor List", "Shoutout to our tutor team!"));
            controller.changePage("COMP2511", "Tutor List");
            String pageResult = controller.renderPage();
            if (pageResult.contains("dark")) {
                seenDark = true;
            } else if (pageResult.contains("light")) {
                seenLight = true;
            }
        }
        assertTrue(seenDark);
        assertTrue(seenLight);
    }

    @Test
    public void MultipleCoursesPagesTest() {
        WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.TUTOR, "dark");

        controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");
        controller.createCourse("COMP2512", "25T1", "Cyrus Cheng");
        controller.createCourse("COMP2513", "25T2", "Nicole Chun");

        controller.addPage("COMP2511",
                new PageContent("COMP2511 Course Outline", "Outline for COMP2511"));

        controller.addPage("COMP2512", new PageContent("COMP2512 Course Outline", "Outline for COMP2512"));
        controller.addPage("COMP2513", new PageContent("COMP2513 Course Outline", "Outline for COMP2513"));

        controller.changePage("COMP2511", "COMP2511 Course Outline");
        assertEquals(
                "PageContainer: Rendering a dark theme page titled COMP2511 Course Outline with body Outline for COMP2511\n",
                controller.renderPage());

        controller.changePage("COMP2512", "COMP2512 Course Outline");
        assertEquals(
                "PageContainer: Rendering a dark theme page titled COMP2512 Course Outline with body Outline for COMP2512\n",
                controller.renderPage());

        controller.changePage("COMP2513", "COMP2513 Course Outline");
        assertEquals(
                "PageContainer: Rendering a dark theme page titled COMP2513 Course Outline with body Outline for COMP2513\n",
                controller.renderPage());
    }

    @Test
    public void NavigatingBackandForth() {

        WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.ADMIN, "dark");

        controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");
        controller.createCourse("COMP2512", "25T2", "Vincent Nguyen");

        controller.addPage("COMP2511",
                new PageContent("COMP2511 Course Outline", "Outline for COMP2511"));

        controller.addPage("COMP2512", new PageContent("COMP2512 Course Outline", "Outline for COMP2512"));

        controller.changePage("COMP2511", "COMP2511 Course Outline");
        assertEquals(
                "PageContainer: Rendering a dark theme page titled COMP2511 Course Outline with body Outline for COMP2511\n",
                controller.renderPage());

        controller.changePage("COMP2512", "COMP2512 Course Outline");
        assertEquals(
                "PageContainer: Rendering a dark theme page titled COMP2512 Course Outline with body Outline for COMP2512\n",
                controller.renderPage());

        controller.navigateBack();
        assertEquals(
                "PageContainer: Rendering a dark theme page titled COMP2511 Course Outline with body Outline for COMP2511\n",
                controller.renderPage());

        controller.resetHistory();
        controller.navigateBack();
        assertEquals(
                "PageContainer: Rendering a dark theme page titled COMP2511 Course Outline with body Outline for COMP2511\n",
                controller.renderPage());
    }

    @Test
    public void EditPagesWithoutPermissionsTest() {
        WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.STUDENT, "dark");

        controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");

        controller.addPage("COMP2511",
                new PageContent("Course Outline", "Outlin for COMP2511"));

        controller.changePage("COMP2511", "Course Outline");

        assertThrows(RuntimeException.class, () -> {
            controller.editPage("COMP2511", "Course Outline", "Outline for COMP2511");
        });
    }

    @Test
    public void EditPagesWithPermissionsTest() {
        WebCMS4Controller controller = new WebCMS4Controller(PermissionLevel.ADMIN, "dark");

        controller.createCourse("COMP2511", "24T3", "Dr Ashesh Mahidadia");

        controller.addPage("COMP2511",
                new PageContent("Course Outline", "Outlin for COMP2511"));

        controller.changePage("COMP2511", "Course Outline");

        assertDoesNotThrow(() -> {
            controller.editPage("COMP2511", "Course Outline", "Outline for COMP2511");
        });

        assertEquals(
                "PageContainer: Rendering a dark theme page titled Course Outline with body Outline for COMP2511\n",
                controller.renderPage());
    }
}
