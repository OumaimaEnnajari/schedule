package com.example.edt_k.Web;

import com.example.edt_k.DTO.Duration_DTO;
import com.example.edt_k.DTO.Exam_Time_DTO;
import com.example.edt_k.Json_Object.DeleteExamTimeObject;
import com.example.edt_k.entity.*;
import com.example.edt_k.repository.DaysRepository;
import com.example.edt_k.repository.DurationRepository;
import com.example.edt_k.repository.GeneRepository;
import com.example.edt_k.service.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/exam_time")
public class AssociationExam_TimeController {
    private Exam_timeServiceImp examTimeService;
    private DaysServiceImp daysServiceImp;
    private DurationServiceImp durationServiceImp;
    private ExamenServiceImp examenServiceImp;
    private GeneServiceImp geneServiceImp;
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/associate-days")
    @Transactional
    public ResponseEntity<List<Exam_Time_DTO>> associateDaysWithExamTimes(@RequestBody List<RequestObject> requestObject)
    {
        if (durationServiceImp.countDuration()!=0||daysServiceImp.countDays()!=0)
        {
            examenServiceImp.DeleteAllExams();
            examTimeService.DeleteAllExamTimes();
            durationServiceImp.supprimertous();
            daysServiceImp.Alldeleted();
            geneServiceImp.deleted();}
        examTimeService.associateDaysWithExamTimes(requestObject);
        List<Exam_Time> examTimes = examTimeService.getExam_Time();
        List<Exam_Time_DTO>examTimeDtos=new ArrayList<>();
        for (Exam_Time examTime:examTimes
        ) {
            examTimeDtos.add(Exam_Time_DTO.toDto(examTime));
        }
        return new ResponseEntity<>(examTimeDtos, HttpStatus.CREATED);
    }
//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/ps")
//    @Transactional
//    public ResponseEntity<HttpStatus> deleteExamtime (@RequestBody DeleteExamTimeObject deleteExamTimeObject){
//        examenServiceImp.DeleteAllExams();
//
//        examTimeService.DeleteAllExamTimes();
//        durationServiceImp.supprimertous();
//        daysServiceImp.Alldeleted();
//
//        geneServiceImp.deleted();
//
//        List<Exam_Time> examTimes = examTimeService.associateDaysWithExamTimes(
//                deleteExamTimeObject.getDaysList(),deleteExamTimeObject.getDurationList());
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/{id}")
//    @Transactional
//    public ResponseEntity<Duration_DTO> updateExamtime (@PathVariable long id, @RequestBody Duration newduration){
//        Duration updatedDuration=durationServiceImp.updateDuration(id,newduration);
//        examenServiceImp.DeleteAllExams();
//
//        examTimeService.DeleteAllExamTimes();
//
//        //durationServiceImp.supprimertous();
//        //daysRepository.deleteAll();
//
//        geneServiceImp.deleted();
//
//        List<Exam_Time> examTimes = examTimeService.associateDaysWithExamTimes(
//                daysServiceImp.getDays(),durationServiceImp.getDurations());
//        List<Duration_DTO> examTimeDtos = new ArrayList<>();
//        for (Exam_Time examTime:examTimes
//        ) {
//            examTimeDtos.add(Duration_DTO.toDto(examTime.getDuration()));
//        }
//        return new ResponseEntity<>(Duration_DTO.toDto(updatedDuration),HttpStatus.OK);
//    }
@CrossOrigin(origins = "http://localhost:3000")
@DeleteMapping("/up/{id}")
@Transactional
public ResponseEntity<HttpStatus> deleteExamtime (@PathVariable long id){

    Optional<Exam_Time>  examTime= examTimeService.findExamTimeByid(id);
    Duration ancienDuration = examTime.get().getDuration();
    Days ancienday= examTime.get().getDays();
    examenServiceImp.DeleteAllExams();

    examTimeService.DeleteExamTimeById(examTime.get().getId());
    durationServiceImp.deleteDuration(ancienDuration.getId());
    daysServiceImp.DeleteDay(ancienday);

    geneServiceImp.deleted();
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<HttpStatus> updateExamtime (@PathVariable long id, @RequestBody RequestObject newExamtime){

        Optional<Exam_Time> examTime= examTimeService.findExamTimeByid(id);
        Duration ancienDuration = examTime.get().getDuration();
        Duration newOne = new Duration();
        newOne.setDebutExamen(newExamtime.getDebut());
        newOne.setFinExamen(newExamtime.getFin());
        Duration updatedDuration=durationServiceImp.updateDuration(ancienDuration.getId(), newOne);

        Days ancienday= examTime.get().getDays();
        Days newDay= new Days();
        newDay.setDate(newExamtime.getDay());
        Days updatedDay=daysServiceImp.updateDays(ancienday.getId(),newDay);
        examenServiceImp.DeleteAllExams();
        geneServiceImp.deleted();
        examTime.get().setDuration(updatedDuration);
        examTime.get().setDays(updatedDay);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllExams() {
        examenServiceImp.DeleteAllExams();
        return new ResponseEntity<>("Tous les examens ont été supprimés.", HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<List<Exam_Time_DTO>> getExam_Times() {
        List<Exam_Time_DTO> examTimeDtos= new ArrayList<>();
        List<Exam_Time> examTimes=examTimeService.getExam_Time();
        for (Exam_Time examTime:examTimes
        ) {
            examTimeDtos.add(Exam_Time_DTO.toDto(examTime));
        }
        return new ResponseEntity<>(examTimeDtos, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/alldays")
    public ResponseEntity<List<Days>> getDays() {
        return new ResponseEntity<>(daysServiceImp.getDays(), HttpStatus.OK);
    }

}
