package net.zfeng.sing.api.controller;

import net.zfeng.sing.api.service.IMusicianService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.Musician;
import net.zfeng.sing.model.MusicianList;
import net.zfeng.sing.model.ResModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaofeng on 16/2/8.
 */
@RestController
@RequestMapping("/musicians")
public class MusicianController {
    @Resource
    private IMusicianService musicianService;

    @RequestMapping(method = RequestMethod.GET)
    public ResModel getSongs(Integer page, HttpServletResponse response) {
        String code = "200";
        String message = "";
        MusicianList musicianList = null;

        try {
            musicianList = musicianService.getMusicians(page);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
            response.setStatus(Integer.parseInt(code));
        }

        return new ResModel(code, message, musicianList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/space/{userId:\\d+}")
    public ResModel getFuns(
            @PathVariable String userId,
            @RequestParam(defaultValue = "1") Integer page,
            HttpServletResponse response
    ) {
        String code = "200";
        String message = "";
        MusicianList musicianList = null;

        try {
            musicianList = musicianService.getFuns(userId, page);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
            response.setStatus(Integer.parseInt(code));
        }

        return new ResModel(code, message, musicianList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/space/{userId:\\d+}/info")
    public ResModel getInfo(@PathVariable String userId, HttpServletResponse response) {
        String code = "200";
        String message = "";
        Musician musician = null;

        try {
            musician = musicianService.getInfo(userId);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
            response.setStatus(Integer.parseInt(code));
        }

        return new ResModel(code, message, musician);
    }

}
