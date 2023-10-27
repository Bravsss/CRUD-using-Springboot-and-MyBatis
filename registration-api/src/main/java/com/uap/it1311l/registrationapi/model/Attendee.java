package com.uap.it1311l.registrationapi.model;

public class Attendee {
    private String attendeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String course;
    private Integer age;
    private Boolean surveyEligibilityTag;

    public Attendee(String attendeeId, String firstName, String middleName, String lastName, String course, Integer age) {
        this.attendeeId = attendeeId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.course = course;
        this.age = age;
        this.surveyEligibilityTag = null;
    }

    public String getAttendeeId() {
        return attendeeId;
    }

    public void setAttendeeId(String attendeeId) {
        this.attendeeId = attendeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Boolean getSurveyEligibilityTag() {
        return surveyEligibilityTag;
    }

    public void setSurveyEligibilityTag(Boolean surveyEligibilityTag) {
        this.surveyEligibilityTag = surveyEligibilityTag;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "attendeeId='" + attendeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course='" + course + '\'' +
                ", age=" + age +
                ", surveyEligibilityTag=" + surveyEligibilityTag +
                '}';
    }
}