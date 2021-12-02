package com.example.controller;

import com.example.dao.ManagerDao;
import com.example.entity.Manager;
import com.example.entity.ReturnBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController extends BaseController {


    @Autowired
    private ManagerDao managerDao;

    /*@RequestMapping("/toresult")
    @ResponseBody
    public ReturnBean toResult(@RequestBody Manager manager) {
        System.out.println("***********************************");
        Map<String, Object> conditions = new HashMap<>();
                 conditions.put("name", manager.getMname());
                 conditions.put("password", manager.getMpassword());
        List<Manager> userList= managerDao.selectByMap(conditions);
        if (userList.size()>0){
            return success(userList);
        }else{
            return fail(userList);
        }
    }*/

}
