## 平台简介
这是一个性格色彩测试项目。
- 前端采用LayUI。
- 后端采用Spring Boot、MyBatis-plus。
- 数据库采用MySQL5.7
- 权限认证使用shiro。
- 支持加载动态权限菜单，多方式轻松权限控制。
- 高效率开发，使用EasyCode插件可以一键生成后端代码。

## 项目功能
- 用户选题测试
    - 用户进入测试题登录界面，通过手机号及姓名进行登录注册，依次回答30个问题，最后点击提交来进行性格测试，系统会根据测试人所选的选项自动生成测试结果。
- 管理后台
    - 业务管理
        - 测试结果管理：测试结果展示、报表下载及发送邮箱。
        - 测试结果大屏展示：测试结果信息统计。
    - 系统管理
        - 用户管理：配置用户登录名、密码、头像以及所担任的角色等详细信息。
        - 部门管理：配置系统组织机构。
        - 菜单管理：配置系统菜单，操作权限，按钮权限标识等。
        - 角色管理：配置角色菜单权限，树结构展现支持数据权限。
        - 操作日志：查看系统操作日志记录。
    - 试题管理
        - 测试题目管理：测试题的增删改查，这里的删除操作使用标志位flag进行逻辑删除（1表示删除，0表示未删除）。

## 环境配置
- 准备工作
    ```javascript
    // 使用的版本
    JDK = 1.8 
    Mysql = 5.7
    Maven = 3.6.3
    ```
- 默认账户/密码：admin/123456
- 数据库和需求文档位置： /src/main/resources/doc/

## 演示图
![后台登录](https://img-blog.csdnimg.cn/img_convert/bdd77e04dc496dce4f0d514235b67c18.png)
![后台登录注册](https://img-blog.csdnimg.cn/img_convert/16863ac1e13a11ad56591ddcab7fd03e.png)
![测试结果管理](https://img-blog.csdnimg.cn/img_convert/eb46a8b16f6bdeaca14a164e5670600c.png)
![测试报告](https://img-blog.csdnimg.cn/img_convert/8cdd639203bf3bb1087c9f4115f8ada8.png)
![用户管理](https://img-blog.csdnimg.cn/img_convert/af05f6b341b31fd093ffa06c5bf1d93d.png)
![角色管理](https://img-blog.csdnimg.cn/img_convert/8da00bab89bdb004b945715b66a51ad9.png)
![菜单管理](https://img-blog.csdnimg.cn/img_convert/fb39045d0dcce0099716482152ba4abb.png)
![日志管理](https://img-blog.csdnimg.cn/img_convert/6ad5d154ab4a06282ff98e1eb296050b.png)


