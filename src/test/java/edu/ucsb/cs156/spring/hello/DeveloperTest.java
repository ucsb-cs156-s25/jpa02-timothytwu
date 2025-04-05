package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Timothy", Developer.getName());
    }


    @Test
    public void getCorrectGitID() {
        assertEquals("timothytwu", Developer.getGithubId());
    }
    @Test
    public void getTeam_correctName() {
        Team t = Developer.getTeam();
        assertEquals("s25-13", t.getName());
        assertTrue(t.getMembers().contains("Timothy"),"Team doesn't contain Timothy");
        assertTrue(t.getMembers().contains("Kenneth"),"Team doesn't contain Kenneth");
        assertTrue(t.getMembers().contains("Nikunj"),"Team doesn't contain Nikunj");
        assertTrue(t.getMembers().contains("Tuan"),"Team doesn't contain Tuan");
        assertTrue(t.getMembers().contains("Conner"),"Team doesn't contain Conner");
        assertTrue(t.getMembers().contains("Cheng"),"Team doesn't contain Cheng");
    }

}
