package com.fee.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fee.Dao.UserDao;
import com.fee.Entity.User;
import com.fee.Vo.CommonResponseVo;
import com.fee.Vo.UserVo;
import com.fee.util.StatusResponse;

@Service
public class UserServieImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public CommonResponseVo addStudent(UserVo vo) {
		CommonResponseVo commonResponseVo = new CommonResponseVo();
		User user = new User();
		try {
			if (vo.getName() != null && !vo.getName().trim().equals("")) {
				user.setName(vo.getName());
			}

			if (vo.getUserName() != null && !vo.getUserName().trim().equals("")) {
				user.setUserName(vo.getUserName());
			}

			if (vo.getPassword() != null && !vo.getPassword().equals("")) {
				user.setPassword(vo.getPassword());
			}

			if (vo.getEmailId() != null && !vo.getEmailId().trim().equals("")) {
				user.setEmailId(vo.getEmailId());
			}

			if (vo.getMobileNumber() != null && !vo.getMobileNumber().trim().equals("")) {
				user.setMobileNumber(vo.getMobileNumber());
			}

			if (vo.getJoiningDate() != null) {
				user.setJoiningDate(vo.getJoiningDate());
			}

			vo.setRoleId(StatusResponse.ROLE_STUDENT_ID);

			vo.setStatus(1);

			User saveUser = userDao.save(user);

			if (saveUser != null) {
				commonResponseVo.setData(saveUser);
				commonResponseVo.setMessage(StatusResponse.SUCCESS_MESSAGE);
				commonResponseVo.setStatus(StatusResponse.SUCCESS_STATUS);
			} else {
				commonResponseVo.setMessage(StatusResponse.ERROR_MESSAGE);
				commonResponseVo.setStatus(StatusResponse.ERROR_STATUS);
			}

			return commonResponseVo;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}
}
