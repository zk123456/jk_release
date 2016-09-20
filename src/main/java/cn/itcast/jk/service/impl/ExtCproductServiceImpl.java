package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ExtCproductDao;
import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.dao.SysCodeDao;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.service.ExtCproductService;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
@Service
public class ExtCproductServiceImpl implements ExtCproductService {
	@Resource
	ExtCproductDao extCproductDao;
	@Autowired
	FactoryDao factoryDao;
	@Autowired
	SysCodeDao sysCodeDao;
	
	public List<ExtCproduct> find(Map paraMap) {
		return extCproductDao.find(paraMap);
	}

	public ExtCproduct get(Serializable id) {
		return extCproductDao.get(id);
	}

	public void insert(ExtCproduct entity) {
		extCproductDao.insert(entity);
	}

	public void update(ExtCproduct entity) {
		extCproductDao.update(entity);
	}

	public void deleteById(Serializable id) {
		extCproductDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		extCproductDao.delete(ids);
	}

	public List<Factory> getFactoryList() {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("state", "1");				//设置只查询状态为启用的厂家
		
		return factoryDao.find(paraMap);
	}

	public List<SysCode> getSysCodeList() {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("parentId", "0104");		//sys_code_b.0104为附件分类
		return sysCodeDao.find(paraMap);
	}	

}
