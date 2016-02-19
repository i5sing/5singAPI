package net.zfeng.sing.api.controller;

import net.zfeng.sing.api.service.IMusicianService;
import net.zfeng.sing.api.service.ISingService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.MusicianList;
import net.zfeng.sing.model.ResModel;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.utils.Conversion;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by zhaofeng on 16/2/8.
 */
@RestController
@RequestMapping("/musicians")
public class MusicianController {
    @Resource
    private IMusicianService musicianService;

    @RequestMapping(method = RequestMethod.GET)
    public ResModel getSongs(Integer page) {
        String code = "200";
        String message = "";
        MusicianList musicianList = null;

        try {
            musicianList = musicianService.getMusicians(page);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
        }

        return new ResModel(code, message, musicianList);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/space/{userId:\\d+}")
    public ResModel getFuns(@PathVariable String userId, @RequestParam(defaultValue = "1") Integer page) {
        String code = "200";
        String message = "";
        MusicianList musicianList = null;

        try {
            musicianList = musicianService.getFuns(userId, page);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
        }

        return new ResModel(code, message, musicianList);
    }

}
