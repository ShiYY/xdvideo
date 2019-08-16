package net.xdclass.xdvideo.mapper;

import java.util.List;
import net.xdclass.xdvideo.domain.Video;
import net.xdclass.xdvideo.provider.VideoProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * video数据访问层
 */
public interface VideoMapper {
    
    @Select("select * from video")
    /*@Results({
        @Result(column = "cover_img", property = "coverImg")
    })*/
    List<Video> getAll();
    
    @Select("select * from video where id = #{id}")
    Video findById(int id);
    
    // @Update("update video set title = #{title} where id = #{id}")
    @UpdateProvider(type = VideoProvider.class, method = "updateVideo")
    int update(Video video);
    
    @Delete("delete from video where id = #{id}")
    int delete(int id);
    
    @Insert("INSERT INTO 'video' ('title`, 'summary', " +
        "'cover_img', 'view_num', 'price', 'create_time'," +
        "'online', 'point')" +
        "VALUES" +
        "(#{title}, #{summary}, #{coverImg}, #{viewNum}, #{price},#{createTime}" +
        ",#{online},#{point});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int save(Video video);
}
