package student_management.dto;

import student_management.entities.Mark;
import student_management.services.MarkService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MarkDto implements MarkService {

    private Connection conn;
    private String query;
    private PreparedStatement ps;

    public MarkDto(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Mark insertMark(Mark mark) {
        try {
            this.query = "INSERT INTO marks (sub1,sub2,sub3,sub4,sub5,total,sId) VALUES (?,?,?,?,?,?,?)";
            this.ps = this.conn.prepareStatement(this.query);
            this.ps.setInt(1, mark.getSub1());
            this.ps.setInt(2, mark.getSub2());
            this.ps.setInt(3, mark.getSub3());
            this.ps.setInt(4, mark.getSub4());
            this.ps.setInt(5, mark.getSub5());
            this.ps.setFloat(6, mark.getTotal());
            this.ps.setInt(7, mark.getsId());

            int i = this.ps.executeUpdate();
            if (i == 1) {
                return mark;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Mark updateMark(Mark mark, int sId) {
        try {

            this.query = "update marks set sub1=?,sub2=?,sub3=?,sub4=?,sub5=?,total=? where sId = ?";
            this.ps = this.conn.prepareStatement(this.query);
            this.ps.setInt(1, mark.getSub1());
            this.ps.setInt(2, mark.getSub2());
            this.ps.setInt(3, mark.getSub3());
            this.ps.setInt(4, mark.getSub4());
            this.ps.setInt(5, mark.getSub5());
            this.ps.setFloat(6, mark.getTotal());
            this.ps.setInt(7, sId);
            ps.executeUpdate();

            return mark;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteMark(int sId) {
        return false;
    }
}
