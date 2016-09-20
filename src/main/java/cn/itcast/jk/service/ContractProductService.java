package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;

/**
 * @Description: 货物service接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
public interface ContractProductService {
	public List<ContractProduct> find(Map paraMap);
	public ContractProduct get(Serializable id);
	public void insert(ContractProduct entity);
	public void update(ContractProduct entity);
	public void deleteById(Serializable id);
	public void delete(Serializable[] ids);
	
	public List<Factory> getFactoryList();		//获取生产厂家下拉列表
}
