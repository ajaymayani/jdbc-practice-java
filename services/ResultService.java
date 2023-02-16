package student_management.services;

import student_management.entities.Result;

public interface ResultService {

    //create
    Result insertResult(Result result);

    //update
    Result updateResult(Result result,int sId);

    //delete
    boolean deleteResult(int sId);
}
