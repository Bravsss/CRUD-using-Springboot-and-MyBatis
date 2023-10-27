package com.uap.it1311l.registrationapi.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.uap.it1311l.registrationapi.model.Attendee;
import com.uap.it1311l.registrationapi.repository.RegistrationMybatisRepository;
import java.util.List;

@RestController
@RequestMapping("/attendees")
public class RegistrationController {
	
	@Autowired
    private RegistrationMybatisRepository registrationRepo;
	
	@PostMapping
    public ResponseEntity<Attendee> registerAttendee(@RequestBody Attendee attendee) {
        registrationRepo.insert(attendee);
        return ResponseEntity.status(HttpStatus.CREATED).body(attendee);
    }
	
	@GetMapping
    public ResponseEntity<List<Attendee>> getAllAttendees() {
        List<Attendee> attendees = registrationRepo.findAll();
        return ResponseEntity.ok(attendees);
    }

	@PutMapping("/survey/eligibility/{course}")
    public ResponseEntity<String> markAttendeesSurveyEligible(@PathVariable String course) {
        List<Attendee> attendees = registrationRepo.findByCourse(course);
        if (attendees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No attendees found for course: " + course);
        }

        for (Attendee attendee : attendees) {
            attendee.setSurveyEligibilityTag(true);
            registrationRepo.updateSurveyEligibilityTag(attendee.getAttendeeId(), true);
        }

        return ResponseEntity.ok("Survey eligibility marked true for all " + course + " attendees.");
    }
	
	@DeleteMapping("/{attendeeId}")
    public ResponseEntity<String> deleteAttendeeById(@PathVariable String attendeeId) {
        if (registrationRepo.existsById(attendeeId)) {
            registrationRepo.deleteById(attendeeId);
            return ResponseEntity.ok("Attendee with ID " + attendeeId + " has been deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Attendee with ID " + attendeeId + " not found.");
        }
    }
}