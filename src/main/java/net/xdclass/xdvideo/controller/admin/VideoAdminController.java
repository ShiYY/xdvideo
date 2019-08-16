package net.xdclass.xdvideo.controller.admin;

import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: W
 * @create: 2019-07-16 19:44
 **/
@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {
    
    @Autowired
    private VideoService videoService;
    
    /**
     * 根据ID删除视频
     *
     * @param video_id id
     */
    @DeleteMapping("del_by_id")
    public Object delById(@RequestParam(value = "video_id", required = true) int video_id) {
        return videoService.delete(video_id);
    }
    
    /**
     * 根据ID更新视频
     */
    @PutMapping("update_by_id")
    public Object update(@RequestBody Video video) {
        return videoService.update(video);
    }
    
    /**
     * 保存视频对象
     */
    @PostMapping("save")
    public Object save(@RequestBody Video video) {
        return videoService.save(video);
    }
}
