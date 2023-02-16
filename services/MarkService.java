package student_management.services;

import student_management.entities.Mark;
import sun.plugin2.message.MarkTaintedMessage;

public interface MarkService {
    //create
    Mark insertMark(Mark mark);

    //update
    Mark updateMark(Mark mark,int sId);

    //delete
    boolean deleteMark(int sId);

}
