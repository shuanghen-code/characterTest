package com.example.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.RoleMenu;
import com.example.service.RoleMenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色和菜单关联表(RoleMenu)表控制层
 *
 * @author makejava
 * @since 2021-12-04 12:30:11
 */
@RestController
@RequestMapping("roleMenu")
public class RoleMenuController extends ApiController {

}