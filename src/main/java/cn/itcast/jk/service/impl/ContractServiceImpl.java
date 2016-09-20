package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
@Service
public class ContractServiceImpl implements ContractService {
	@Resource
	ContractDao contractDao;
	
	public List<Contract> find(Map paraMap) {
		return contractDao.find(paraMap);
	}

	public Contract get(Serializable id) {
		return contractDao.get(id);
	}

	public void insert(Contract entity) {
		contractDao.insert(entity);
	}

	public void update(Contract entity) {
		contractDao.update(entity);
	}

	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Serializable[] ids) {
		contractDao.delete(ids);
	}

	public void updateState(Map map) {
		contractDao.updateState(map);
	}

	public ContractVO view(Serializable id) {
		return contractDao.view(id);
	}

}
