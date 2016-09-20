package cn.itcast.jk.dao.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.ContractDao;
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description:购销合同dao实现类
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
@Repository
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao {
	public ContractDaoImpl() {
		super.setNs("cn.itcast.jk.mapper.ContractMapper");
	}

	public void updateState(Map map) {
		super.getSqlSession().update(super.getNs() + ".updateState", map);
	}

	public ContractVO view(Serializable id) {
		return super.getSqlSession().selectOne(super.getNs() + ".view", id);
	}
}
