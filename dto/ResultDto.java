package student_management.dto;

import student_management.entities.Result;
import student_management.services.ResultService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class ResultDto implements ResultService {

    private Connection conn;
    private String query;
    private PreparedStatement ps;

    public ResultDto(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Result insertResult(Result result) {
        try {
            this.query = "INSERT INTO result (percentage,grade,sId) VALUES (?,?,?)";
            this.ps = this.conn.prepareStatement(this.query);
            this.ps.setFloat(1, result.getPercentage());
            this.ps.setString(2, result.getGrade());
            this.ps.setInt(3, result.getsId());

            int i = this.ps.executeUpdate();
            if (i == 1) {
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Result updateResult(Result result, int sId) {
        try {

            this.query  = "update result set percentage=?,grade=? where sId = ?";
            ps = this.conn.prepareCall(this.query);
            ps.setFloat(1,result.getPercentage());
            ps.setString(2, result.getGrade());
            ps.setInt(3, sId);
            ps.executeUpdate();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteResult(int sId) {
        return false;
    }


}
