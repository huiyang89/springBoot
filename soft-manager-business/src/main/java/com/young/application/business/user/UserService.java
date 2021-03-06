package com.young.application.business.user;

import com.young.application.page.Pager;
import com.young.application.entity.User;
import com.young.application.system.request.UserBean;

/**
 * Created by huiyangchen1 on 2017/6/15.
 */
public interface UserService {

    public User findUserInfo(String userName, String pass);


    Pager findUserListByPage(UserBean bean);

    void saveUserInfo(User user);

    void deleteUser(Long id);
}
