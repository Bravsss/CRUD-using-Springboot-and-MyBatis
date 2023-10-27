package com.uap.it1311l.registrationapi.repository;

import org.apache.ibatis.annotations.*;
import com.uap.it1311l.registrationapi.model.Attendee;
import java.util.List;

@Mapper
public interface RegistrationMybatisRepository {
    @Insert("INSERT INTO attendees(firstName, middleName, lastName, course, age) VALUES (#{firstName}, #{middleName}, #{lastName}, #{course}, #{age})")
    void insert(Attendee attendee);
    
    @Select("SELECT * FROM attendees WHERE course = #{course}")
    List<Attendee> findByCourse(String course);
    
    @Select("SELECT * FROM attendees WHERE attendeeId = #{attendeeId}")
    Attendee findById(String attendeeId);
    
    @Update("UPDATE attendees SET surveyEligibilityTag = #{surveyEligibilityTag} WHERE attendeeId = #{attendeeId}")
    void updateSurveyEligibilityTag(@Param("attendeeId") String attendeeId, @Param("surveyEligibilityTag") boolean surveyEligibilityTag);
    
    @Select("SELECT COUNT(*) FROM attendees WHERE attendeeId = #{attendeeId}")
    boolean existsById(String attendeeId);
    
    @Delete("DELETE FROM attendees WHERE attendeeId = #{attendeeId}")
    void deleteById(String attendeeId);
    
    @Select("SELECT * FROM attendees")
    List<Attendee> findAll();
}