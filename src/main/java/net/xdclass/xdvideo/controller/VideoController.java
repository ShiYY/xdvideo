package net.xdclass.xdvideo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.HashMap;
import java.util.List;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.service.VideoService;
import net.xdclass.xdvideo.service.impl.VideoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * video接口
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    /**
     * 分页接口
     *
     * @param page 当前第几页, 默认是第一页
     * @param size 每页显示条数, 默认十条
     */
    @GetMapping("page")
    public Object pageVideo(@RequestParam(value = "page", defaultValue = "1") int page,
        @RequestParam(value = "size", defaultValue = "5") int size) {
        PageHelper.startPage(page, size);
        List<Video> list = videoService.getAll();
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        HashMap<String, Object> data = new HashMap<>();
        data.put("total_size", pageInfo.getTotal()); // 总条数
        data.put("total_page", pageInfo.getPages()); // 总页数
        data.put("current_page", page); // 当前页
        data.put("data", pageInfo.getList()); // 数据
        return data;
    }
    
    /**
     * 根据ID查询视频
     *
     * @param video_id id
     */
    @GetMapping("find_by_id")
    public Object findById(@RequestParam(value = "video_id", required = true) int video_id) {
        return videoService.findById(video_id);
    }
    
}
