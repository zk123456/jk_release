package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.Factory;

/**
 * @Description: 生产厂家业务接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
public interface FactoryService {
	public List<Factory> find(Map paraMap);
	public Factory get(Serializable id);
	public void insert(Factory entity);
	public void update(Factory entity);
	public void deleteById(Serializable id);
	public void delete(Serializable[] ids);
	
	public void updateState(Map map);
}
