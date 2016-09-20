package cn.itcast.jk.dao;

import java.util.Map;

import cn.itcast.jk.domain.Factory;

/**
 * @Description:生产厂家的dao接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
public interface FactoryDao extends BaseDao<Factory> {
	public void updateState(Map map);		//批量修改状态
}
