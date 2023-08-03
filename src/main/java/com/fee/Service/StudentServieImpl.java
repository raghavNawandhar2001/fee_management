package com.fee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fee.Dao.StudentDao;
import com.fee.Entity.Student;
import com.fee.Vo.CommonResponseVo;
import com.fee.Vo.StudentVo;

@Service
public class StudentServieImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public CommonResponseVo addStudent(StudentVo vo) {
        CommonResponseVo commonResponseVo = new CommonResponseVo();
        Student student = new Student();

        if (vo.getStudentName() != null && !vo.getStudentName().trim().equals("")) {
            student.setStudentName(vo.getStudentName());

        }

        if (vo.getEmailId() != null && !vo.getEmailId().trim().equals("")) {
            student.setEmailId(vo.getEmailId());
        }

        student.setUserName(vo.getUserName());

        return null;

    }
}
