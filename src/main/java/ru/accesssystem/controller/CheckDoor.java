package ru.accesssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.accesssystem.service.CheckDoorService;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Bashirova Milyausha
 */
@RestController
public class CheckDoor {

    @Autowired
    private CheckDoorService checkDoorService;

    @GetMapping("/check")
    public Integer getStatusCheckDoor(@RequestParam("roomId") Integer roomId,
                                      @RequestParam("entrance") Boolean entrance,
                                      @RequestParam("keyId") Integer keyId,
                                      ServletRequest servletRequest) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String token = httpServletRequest.getHeader("token");
        return checkDoorService.getResultCheck(roomId, entrance, keyId, token);
    }

}
