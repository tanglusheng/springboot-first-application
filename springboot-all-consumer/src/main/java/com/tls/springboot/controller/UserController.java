package com.tls.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tls.springboot.model.User;
import com.tls.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model,@RequestParam(value = "curPage",required = false)Integer curPage){
        if(null==curPage||curPage<1){
            curPage=1;
        }
        int pageSize=10;

        int totalRows = userService.getUserByTotal();
        //计算分页
        int totalPages=totalRows/pageSize;
        int left=totalRows%pageSize;

        if(left>0){
            totalPages=totalPages+1;
        }
        if(curPage>totalPages){
            curPage=totalPages;
        }

        int startRow=(curPage-1)*pageSize;
        Map<String,Object> paramMap=new HashMap<>();
        paramMap.put("pageRow",startRow);
        paramMap.put("pageSize",pageSize);
        List<User> userList = userService.getUserByPage(paramMap);
        model.addAttribute("userList",userList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totalPages",totalPages);
        return "index";
    }
    @RequestMapping("/delete")
    public String delete(Integer id){
        int i=userService.deleteUser(id);
        if(i==1){
            System.out.println("删除成功");
        }
        return "redirect:index";
    }

    @RequestMapping("/user/toUpdateUser")
    public String toUpdateUser(Model model,Integer id){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "addUser";
    }

    @RequestMapping("/user/toAddUser")
    public String toAddUser(Model model){
//        User user = new User();
//        model.addAttribute("user",user);
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(User user){
        if(user.getId()!=null){
            //修改
            int i=userService.updateUser(user);
            if(i==1){
                System.out.println("修改成功");
            }
        }else{
            int i=userService.addUser(user);
            if(i==1){
                System.out.println("新增成功");
            }
        }
        return "redirect:index";
    }
}
