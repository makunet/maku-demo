package net.maku.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.maku.entity.UserLogEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户日志
 * 
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface UserLogDao extends BaseMapper<UserLogEntity> {


}