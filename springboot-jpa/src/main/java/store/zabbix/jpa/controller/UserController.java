package store.zabbix.jpa.controller;

import store.zabbix.jpa.model.SysUser;
import store.zabbix.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("add")
    public SysUser addUser(@RequestBody SysUser sysUser) {
        return userRepository.save(sysUser);
    }

    @GetMapping("all")
    public List<SysUser> getUserList() {
        return userRepository.findAll();
    }

    @GetMapping("get/{id}")
    public SysUser getUserList(@PathVariable("id") Long id) {
        return userRepository.getOne(id);
    }

    @PutMapping("update")
    public SysUser updateUser(@RequestBody SysUser sysUser) {
        return userRepository.saveAndFlush(sysUser);
    }

    @DeleteMapping("del/{id}")
    public void delUser(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }
}
