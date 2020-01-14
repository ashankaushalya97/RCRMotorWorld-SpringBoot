package lk.ijse.dep.rcrmoto.business.custom.impl;

import lk.ijse.dep.rcrmoto.business.custom.LoginBO;
import lk.ijse.dep.rcrmoto.dao.AdminDAO;
import lk.ijse.dep.rcrmoto.dto.LoginDTO;
import lk.ijse.dep.rcrmoto.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class LoginBOImpl implements LoginBO {
    @Autowired
    AdminDAO adminDAO;

    @Transactional(readOnly = true)
    @Override
    public boolean authentication(LoginDTO loginDTO)  {
            return adminDAO.authentication(loginDTO.getUsename(), loginDTO.getPassword())>0;
    }

}
