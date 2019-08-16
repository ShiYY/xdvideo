package net.xdclass.xdvideo.service.impl;

import java.util.List;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.mapper.VideoMapper;
import net.xdclass.xdvideo.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Autowired
    private VideoMapper videoMapper;
    
    @Override
    public List<Video> getAll() {
        return videoMapper.getAll();
    }
    
    @Override
    public Video findById(int id) {
        return videoMapper.findById(id);
    }
    
    @Override
    public int update(Video video) {
        return videoMapper.update(video);
    }
    
    @Override
    public int delete(int id) {
        return videoMapper.delete(id);
    }
    
    @Override
    public int save(Video video) {
        return videoMapper.save(video);
    }
}
