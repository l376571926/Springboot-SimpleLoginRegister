package tonight.group.simplelogin.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tonight.group.simplelogin.bean.BaseResponse;
import tonight.group.simplelogin.bean.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    private List<User> mUserList = new ArrayList<>();

    @RequestMapping("/login")
    public BaseResponse login(String username, String password) {
        if (StringUtils.isEmpty(username)) {
            return new BaseResponse(-1, "username不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return new BaseResponse(-1, "password不能为空");
        }

        boolean isExist = false;
        for (User user : mUserList) {
            String userName = user.getUserName();
            String password1 = user.getPassword();
            if (userName.equals(username)) {
                isExist = true;
                if (!password1.equals(password)) {
                    return new BaseResponse(-1, "密码不正确");
                }
            }
        }
        if (!isExist) {
            return new BaseResponse(-1, "用户不存在");
        }

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("登录成功");
        return baseResponse;
    }

    @RequestMapping("/register")
    public BaseResponse register(String username, String password) {
        if (StringUtils.isEmpty(username)) {
            return new BaseResponse(-1, "username不能为空");
        }
        if (StringUtils.isEmpty(password)) {
            return new BaseResponse(-1, "password不能为空");
        }

        for (User user : mUserList) {
            String userName = user.getUserName();
            if (userName.equals(username)) {
                return new BaseResponse(-1, "用户已存在");
            }
        }
        mUserList.add(new User(username, password));

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(0);
        baseResponse.setMsg("注册成功");
        return baseResponse;
    }
}
