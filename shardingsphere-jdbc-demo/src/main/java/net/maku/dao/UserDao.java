package net.maku.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.maku.entity.UserEntity;

import org.apache.ibatis.annotations.Mapper;


/**
 * 用户
 * 
 * @author 阿沐 babamu@126.com
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {


}