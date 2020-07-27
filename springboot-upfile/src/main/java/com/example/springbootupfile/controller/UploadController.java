package com.example.springbootupfile.controller;

import com.example.springbootupfile.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping("upload")
    public ModelAndView upload(@RequestParam MultipartFile file) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        Map<Object, Object> map = uploadService.uploadFile(file);
        modelAndView.setViewName("result");
        modelAndView.addObject("code", map.get("code"));
        modelAndView.addObject("msg", map.get("msg"));
        return modelAndView;
    }

    @GetMapping("index")
    public String index() {

        return "index.html";
    }
}
