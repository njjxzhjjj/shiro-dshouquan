package com.xiexin.dao;

import com.xiexin.bean.Admin;
import com.xiexin.bean.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminDAO {
    long countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(Integer adminId);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    //5张表 权限 联查
    //N张表的返回值是个啥  listmap
    //参数还是map
    List<Map> selectMore(Map map);
}