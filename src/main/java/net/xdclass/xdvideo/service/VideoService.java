package net.xdclass.xdvideo.service;

import java.util.List;
import net.xdclass.xdvideo.domain.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 视频业务类接口
 */
public interface VideoService {
    
    List<Video> getAll();
    
    Video findById(int id);
    
    int update(Video video);
    
    int delete(int id);
    
    int save(Video video);
}
