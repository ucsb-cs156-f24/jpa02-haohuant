package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test 
    public void equals_same_object() {
        assertEquals(true, team.equals(team));
    }

    @Test 
    public void equals_different_class() {
        String str = new String("Hello, World!");
        assertEquals(false, team.equals(str));
    }

    /* Used in next two tests */
    Team t = new Team("test-team"); 

    @Test 
    public void equals_other_name_and_other_members() {
        assertEquals(true, team.equals(t));
    }

    @Test 
    public void equals_other_name_and_not_other_members() {
        t.addMember("test-person");
        assertEquals(false, team.equals(t));
    }

    @Test 
    public void equals_not_other_name_and_other_members() {
        t.setName("test-team-2");
        assertEquals(false, team.equals(t));
    }

    @Test
    public void hashCode_returns_correct_hash() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    @Test 
    public void hashCode_returns_expected_result() {
        Team t2 = new Team("hashCode-test");
        int result = t2.hashCode();
        int expectedResult = 564204293;
        assertEquals(expectedResult, result);
    }

}
