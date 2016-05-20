package net.zfeng.sing.api.controller;

import net.zfeng.sing.api.service.ISongService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.ResModel;
import net.zfeng.sing.model.Song;
import net.zfeng.sing.model.SongList;
import net.zfeng.sing.utils.Conversion;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaofeng on 16/2/5.
 */
@RestController
@RequestMapping("/songs")
public class SongController {
    @Resource
    private ISongService singService;

    @RequestMapping(method = RequestMethod.GET)
    public ResModel getSongs(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(required = true) String type,
            @RequestParam(required = true) String category,
            HttpServletResponse response
    ) {
        String code = "200";
        String message = "";
        SongList songs = null;

        try {
            songs = singService.getSongs(Conversion.convertSingType(type), Conversion.convertSingCategory(category), page);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
            response.setStatus(Integer.parseInt(code));
        }

        return new ResModel(code, message, songs);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{songId:\\d+}")
    public ResModel getSong(
            @RequestParam(required = true) String type,
            @PathVariable String songId,
            @RequestParam(defaultValue = "1") Integer page,
            HttpServletResponse response
    ) {
        String code = "200";
        String message = "";
        Song song = null;

        try {
            song = singService.getSong(Conversion.convertSingType(type), songId, page);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
            response.setStatus(Integer.parseInt(code));
        }

        return new ResModel(code, message, song);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/space/{userId:\\d+}")
    public ResModel getPersonalSongs(
            @RequestParam(required = true) String type,
            @PathVariable String userId,
            @RequestParam(defaultValue = "1") Integer page,
            HttpServletResponse response
    ) {
        String code = "200";
        String message = "";
        SongList songs = null;

        try {
            songs = singService.getPersonalSongs(userId, Conversion.convertSingType(type), page);
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
            response.setStatus(Integer.parseInt(code));
        }

        return new ResModel(code, message, songs);
    }
}
