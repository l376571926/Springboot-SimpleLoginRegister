# Springboot-SimpleLoginRegister
不带数据库的简单登录注册Springboot项目

1.new project-->spring initializr

2.type-->下拉选项中选择gradle project(...)

3.选中web-->勾选web services

4.新建一个ApiController类并加上@RestController注解

5.添加两个带@RequestMapping("/*")的方法，括号中为api接口请求的短路径

6.完善登录注册逻辑