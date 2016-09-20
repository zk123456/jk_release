package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractProductDao;
import cn.itcast.jk.dao.FactoryDao;
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractProductService;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
@Service
public class ContractProductServiceImpl implements ContractProductService {
	@Resource
	ContractProductDao contractProductDao;
	@Autowired
	FactoryDao factoryDao;
	
	public List<ContractProduct> find(Map paraMap) {
		return contractProductDao.find(paraMap);
	}

	public ContractProduct get(Serializable id) {
		return contractProductDao.get(id);
	}

	public void insert(ContractProduct entity) {
		contractProductDao.insert(entity);
	}

	public void update(ContractProduct entity) {
		contractProductDao.update(entity);
	}

	public void deleteById(Serializable id) {
		contractProductDao.deleteById(id);
	}

	public void delete(Serializable[] ids) {
		contractProductDao.delete(ids);
	}

	public List<Factory> getFactoryList() {
		Map<String,Object> paraMap = new HashMap<String,Object>();
		paraMap.put("state", "1");		//设置只查询状态为启用的厂家
		
		return factoryDao.find(paraMap);
	}	

}
