package cn.itcast.jk.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.OutProductDao;
import cn.itcast.jk.vo.OutProductExtVO;
import cn.itcast.jk.vo.OutProductVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
@Repository
public class OutProductDaoImpl extends BaseDaoImpl<OutProductVO> implements OutProductDao {
	//默认构造中设置命名空间
	public OutProductDaoImpl() {
		super.setNs("cn.itcast.jk.mapper.OutProductMapper");
	}

	public List<OutProductExtVO> findExt(String contractProductId) {
		return super.getSqlSession().selectList(super.getNs()+".findExt", contractProductId);
	}
}
