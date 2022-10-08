package com.mybatis.loadMapper;

import com.mybatis.annotation.Select;
import com.mybatis.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper {


  @Select("select * from user")
  public List<Map<String,Object>>  selectUser();

}
