package dev.ammar.aero;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectSmokeTest {
    @Test void projectIdentityIsPresent() {
        assertEquals("Volta Aero Showcase", "Volta Aero Showcase");
        assertTrue(Runtime.version().feature() >= 17, "Build must run on a modern Java runtime");
    }
}