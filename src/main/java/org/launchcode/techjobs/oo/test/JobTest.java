package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJob = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob.getId(), testJob2.getId());

    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob3.getName() instanceof String);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob3.getPositionType() instanceof PositionType);

        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().toString());
        assertEquals("Desert", testJob3.getLocation().toString());
        assertEquals("Quality control", testJob3.getPositionType().toString());
        assertEquals("Persistence", testJob3.getCoreCompetency().toString());

    }

    @Test
    public void testJobsForEquality() {
        Job testJob4 = new Job("Canine specialist", new Employer("PetCo"), new Location("Kansas City"), new PositionType("Animal science"), new CoreCompetency("Patience"));
        Job testJob5 = new Job("Canine specialist", new Employer("PetCo"), new Location("Kansas City"), new PositionType("Animal science"), new CoreCompetency("Patience"));

        assertFalse(testJob4.equals(testJob5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob6 = new Job("Front end developer", new Employer("Google"), new Location("San Francisco"), new PositionType("Java development"), new CoreCompetency("Organization"));
        String testString = testJob6.toString();
        String expectedString = "\n";

        assertEquals(expectedString, testString.substring(0,1));
        assertEquals(expectedString, testString.substring(testString.length() - 1,testString.length()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob7 = new Job("Lead singer", new Employer("Journey"), new Location("California"), new PositionType("Vocals"), new CoreCompetency("Public speaking"));
        String testString2 = testJob7.toString();
        String expectedString2 = "\n" + "ID: 1" + "\n" + "Name: Lead singer" + "\n" + "Employer: Journey" + "\n" + "Location: California"  + "\n" + "Position Type: Vocals" + "\n" + "Core Competency: Public speaking" + "\n";

        assertEquals(expectedString2, testString2);

    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob8 = new Job("Dog parent", new Employer(), new Location("Work from home"), new PositionType("Pet care"), new CoreCompetency("Big heart"));
        String testString3 = testJob8.toString();
        String expectedString2 = "\n" + "ID: 1" + "\n" + "Name: Dog parent" + "\n" + "Employer: Data not available" + "\n" + "Location: Work from home"  + "\n" + "Position Type: Pet care" + "\n" + "Core Competency: Big heart" + "\n";

    }



}