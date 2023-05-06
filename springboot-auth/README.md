### springboot-admin

Java 后端快速开发模板

### 技术栈

| 技术         | 版本/说明              |
| ------------ | ---------------------- |
| MySQL DB     | 8.0.29                 |
| Spring Boot  | 2.7.0                  |
| Mybatis Plus | 3.5.2                  |
| 权限         | Spring Security        |
| 登录         | [Json Web Token](https://jwt.io/) |
| API接口文档  | Knife4j + OpenAPI3     |

### 功能模块

- [x] 集成 Spring Security 权限模块
  - [项目集成 Spring Security 做登录鉴权（一）](https://juejin.cn/post/7124859232679100423)
  - [项目集成 Spring Security 自定义登录（二）](https://juejin.cn/post/7125225162198220813)
  - [项目集成 Spring Security 携带 token 访问接口（三）](https://juejin.cn/post/7125651443196887053)
  - [安全框架 Spring Security 自定义异常（四）](https://juejin.cn/post/7126191963212087309)
- [x] 登录获取唯一 token 标识
- [x] 标准化 Restful 接口返回
- [x] 全局异常处理
- [ ] 接口文档
- [ ] 日志处理
- [ ] 用户管理
- [ ] 角色管理
- [ ] 菜单管理
