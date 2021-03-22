package by.htp.project.service.impl;

import by.htp.project.bean.RegistrationInfo;
import by.htp.project.bean.User;
import by.htp.project.constant.Message;
import by.htp.project.dao.DAOException;
import by.htp.project.dao.DAOProvider;
import by.htp.project.dao.UserDAO;
import by.htp.project.service.ServiceException;
import by.htp.project.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Override
	public User authorization(String login, String password) throws ServiceException {
		// validation
		if(login == null || "".equals(login) ) {// to bo cont....
			throw new ServiceException(Message.LOGINATION_ERR);
		}
		
		DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDAO = provider.getUserdao();
        
		User user = null;
		try {
			//System.out.println("try-catch UserService.reg");
			if(userDAO.isUser(login)) {
				user = userDAO.authorization(login, password);
				//System.out.println(user.toString());
			}
		}catch(DAOException e) {
			throw new ServiceException(Message.USER_NOT_EXIST_ERR, e);
		}
		return user;
	}

	@Override
	public boolean registration(RegistrationInfo regInfo) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
        UserDAO userDAO = provider.getUserdao();
        
        boolean isRegisterSuccess = false;
        User user = null;
        
        // Проверить наличие юзера в БД
        // Если юзера нет в БД -> отправляем данные для регистрации
        try {
        	//System.out.println("try-catch UserService.reg");
        	if(!userDAO.isUser(regInfo.getLogin())) {
        		user = new User(regInfo.getLogin(), regInfo.getPassword(), regInfo.getName(), regInfo.getSurname());
        		//System.out.println("login " + user.getLogin());
        		//System.out.println();
        		isRegisterSuccess = userDAO.registration(user);
        		//System.out.println("isRegisterSuccess = " + isRegisterSuccess);
        	}
		}catch(DAOException e) {
			throw new ServiceException(Message.REGISTR_ERR, e);
		}
        
        return isRegisterSuccess;
	}
}