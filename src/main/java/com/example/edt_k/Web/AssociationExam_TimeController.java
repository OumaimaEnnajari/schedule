package com.example.edt_k.Web;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;
import com.example.edt_k.entity.Exam_Time;
import com.example.edt_k.service.Exam_timeService;
import com.example.edt_k.service.Exam_timeServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/exam_time")
public class AssociationExam_TimeController {
    private Exam_timeServiceImp examTimeService;
    @PostMapping("/associate-days")
    public ResponseEntity<Exam_Time> associateDaysWithExamTimes(
            @RequestBody List<Days> daysList, @RequestBody List<Duration> durationList) {
        return new ResponseEntity<>(examTimeService.associateDaysWithExamTimes(daysList, durationList), HttpStatus.CREATED);
    }
}
