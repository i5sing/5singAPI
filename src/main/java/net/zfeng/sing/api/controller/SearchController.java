package net.zfeng.sing.api.controller;

import net.zfeng.sing.api.service.ISearchService;
import net.zfeng.sing.exception.SingDataException;
import net.zfeng.sing.model.ResModel;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhaofeng on 16/2/28.
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Resource
    private ISearchService searchService;

    @RequestMapping(method = RequestMethod.POST)
    public ResModel search(@RequestBody SearchModel searchModel, HttpServletResponse response) {
        String code = "200";
        String message = "";
        Object results = null;

        try {
            results = searchService.search(searchModel.getType(), searchModel.getKey(), searchModel.getPage());
        } catch (SingDataException e) {
            code = "400";
            message = e.getMessage();
            response.setStatus(Integer.parseInt(code));
        }

        return new ResModel(code, message, results);
    }
}
/*
* Search Model 不能作为内部类 否则否则和RequestBody 共同使用报415/400错误.
*/
class SearchModel {
    public String type;
    public String key;
    public Integer page;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
