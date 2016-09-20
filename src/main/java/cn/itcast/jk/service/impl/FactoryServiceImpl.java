package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;

/**
 * @Description: 生产厂家业务实现类
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
@Service
public class FactoryServiceImpl implements FactoryService {

	@Autowired
	FactoryDao factoryDao;
	
	public List<Factory> find(Map paraMap) {
		return factoryDao.find(paraMap);
	}

	public Factory get(Serializable id) {
		return factoryDao.get(id);
	}

	public void insert(Factory entity) {
		factoryDao.insert(entity);
	}

	public void update(Factory entity) {
		factoryDao.update(entity);
	}

	public void deleteById(Serializable id) {
		factoryDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		factoryDao.delete(ids);
	}

	public void updateState(Map map) {
		factoryDao.updateState(map);
	}

}
