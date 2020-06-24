package com.sc.controller;

import com.sc.util.StringEscapeEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //防止XSS攻击
        binder.registerCustomEditor(String.class, new StringEscapeEditor(false, false));
    }
}
