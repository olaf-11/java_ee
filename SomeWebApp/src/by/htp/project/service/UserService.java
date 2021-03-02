package by.htp.project.service;

import by.htp.project.bean.RegistrationInfo;
import by.htp.project.bean.User;

public interface UserService {
	User authorization(String login, String passport) throws ServiceException;
	boolean registration(RegistrationInfo regInfo) throws ServiceException;

}
