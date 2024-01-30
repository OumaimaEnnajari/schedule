package com.example.edt_k.Web;

import com.example.edt_k.entity.*;
import com.example.edt_k.service.Exam_timeService;
import com.example.edt_k.service.Exam_timeServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/exam_time")
public class AssociationExam_TimeController {
    private Exam_timeServiceImp examTimeService;
    @PostMapping("/associate-days")
    public ResponseEntity<List<Exam_Time>> associateDaysWithExamTimes(
            @RequestBody RequestObject requestObject) {
        List<Exam_Time> examTimes = examTimeService.associateDaysWithExamTimes(
                requestObject.getDaysList(), requestObject.getDurationList());
        return new ResponseEntity<>(examTimes, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Exam_Time>> getExam_Times() {
        return new ResponseEntity<>(examTimeService.getExam_Time(), HttpStatus.OK);
    }
}
