package com.final_project.stock.service;

import java.util.ArrayList;

import com.final_project.stock.dao.UserTableDao;
import com.final_project.stock.dto.UserTableDto;

public class UserTableService {

		public int equalcheck(String userid, String userpassword) throws Exception {
			UserTableDao usertabledao = new UserTableDao();
			ArrayList<UserTableDto> usertable = usertabledao.isexistuserid();
			int check = 0;
			for (int i = 0; i < usertable.size(); i++) {
				if (userid.equals(usertable.get(i).getUserid())
						&& userpassword.equals(usertable.get(i).getUserpassword())) {
					check = 1;
					break;
				} else {
					check = 0;
				}
				
			}
			return check;

		}

}
