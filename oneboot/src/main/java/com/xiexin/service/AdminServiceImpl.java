package com.xiexin.service;

import com.xiexin.bean.Admin;
import com.xiexin.bean.AdminExample;
import com.xiexin.dao.AdminDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired(required = false)
	private AdminDAO adminDAO;
	public long countByExample(AdminExample example){
    	return adminDAO.countByExample(example);
    }

	public int deleteByExample(AdminExample example){
    	return adminDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return adminDAO.deleteByPrimaryKey(id);
    }

	public int insert(Admin record){
    	return adminDAO.insert(record);
    }

	public int insertSelective(Admin record){

		return adminDAO.insertSelective(record);
    }

	public List<Admin> selectByExample(AdminExample example){
    	return adminDAO.selectByExample(example);
    }

	public Admin selectByPrimaryKey(Integer id){
    	return adminDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(Admin record, AdminExample example){
    	return adminDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(Admin record, AdminExample example){
    	return adminDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(Admin record){
    	return adminDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(Admin record){
    	return adminDAO.updateByPrimaryKey(record);
    }

	@Override
	public List<Map> selectMore(Map map) {
		return adminDAO.selectMore(map);
	}


}
