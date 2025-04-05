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
    public void checkEqualObj() {
        Team team2 = new Team("test-team");
        assert(team2.equals(team2));
    }

    @Test
    public void checkNotEqualObj() {
        Team team2 = new Team("test-team2");
        Team team3 = new Team("test-team3");
        assert(!team2.equals(team3));
    }
    @Test
    public void notTeamType() {
        String notTeam = "not a team";
        assert(!team.equals(notTeam));
    }
    @Test
    public void TeamToString() {
        Team team = new Team("test-team");  
        String teamString = team.toString();
        assert(teamString.equals("Team(name=test-team, members=[])"));
    }
    @Test
    public void testHashCode() {
        Team team2 = new Team("test-team");
        Team team3 = new Team("test-team3");
        assert(team.hashCode() == team2.hashCode());
        assert(!(team2.hashCode() == team3.hashCode()));
    }

    @Test
    public void testMemberHash(){
        Team team2 = new Team("test-team");
        team2.addMember("Timothy");
        
        Team team3 = new Team("test-team2");
        team3.addMember("Timothy2");

        assert(!(team2.hashCode() == team3.hashCode()));
       
    }
    @Test
    public void testBitOr(){
        Team team2 = new Team("test-team");
        team2.addMember("Timothy");
        
        int hashCheck = team2.name.hashCode() | team2.members.hashCode();
        assert(hashCheck == team2.hashCode());
    }

}
