package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description: 购销合同service接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
public interface ContractService {
	public List<Contract> find(Map paraMap);
	public Contract get(Serializable id);
	public void insert(Contract entity);
	public void update(Contract entity);
	public void deleteById(Serializable id);
	public void delete(Serializable[] ids);
	
	public void updateState(Map map);
	public ContractVO view(Serializable id);
}
