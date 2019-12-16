package com.login.study.kotlin_security.account

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.http.HttpServletRequest

@Controller
@RequestMapping("/view")
class AccountController {
    @RequestMapping("/success")
    fun success(request: HttpServletRequest): String {
        return "success"
    }
}