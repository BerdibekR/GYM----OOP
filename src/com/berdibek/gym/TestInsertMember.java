package com.berdibek.gym;

import com.berdibek.gym.database.MemberDAO;
import com.berdibek.gym.model.StudentMember;

public class TestInsertMember {

    public static void main(String[] args) throws Exception {

        StudentMember m =
                new StudentMember(0, "Dastan", 19, "Student", "AITU");

        MemberDAO dao = new MemberDAO();
        dao.insertMember(m);
    }
}