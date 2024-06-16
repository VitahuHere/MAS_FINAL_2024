package org.miras.finalproject.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.miras.finalproject.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDetailsDTO {
    private Long id;
    private String name;
    private List<StudentDTO> students;
    private List<GetTaskDTO> tasks;
    private List<OpinionDTO> opinions;
    private List<TutorialDTO> tutorials;

    public CourseDetailsDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.students = course.getStudents().stream().map(StudentDTO::new).toList();
        this.tasks = course.getTasks().stream().map(GetTaskDTO::new).toList();
        this.opinions = course.getOpinions().stream().map(OpinionDTO::new).toList();
        Set<Tutorial> tutorialList = course.getTutorials();
        List<TutorialDTO> newTutorialList = new ArrayList<>();
        for (Tutorial tutorial : tutorialList) {
            if (tutorial instanceof TextTutorial) {
                newTutorialList.add(new TutorialDTO((TextTutorial) tutorial));
            }
            else if (tutorial instanceof VideoExplainedTutorial) {
                newTutorialList.add(new TutorialDTO((VideoExplainedTutorial) tutorial));
            }
            else if (tutorial instanceof VideoTutorial) {
                newTutorialList.add(new TutorialDTO((VideoTutorial) tutorial));
            }
        }
        this.tutorials = newTutorialList;
    }
}
