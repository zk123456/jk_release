package cn.itcast.jk.dao.impl;

import org.springframework.stereotype.Repository;

import cn.itcast.jk.dao.SysCodeDao;
import cn.itcast.jk.domain.SysCode;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-6-9
 */
@Repository
public class SysCodeDaoImpl extends BaseDaoImpl<SysCode> implements SysCodeDao {
	public SysCodeDaoImpl() {
		this.setNs("cn.itcast.jk.mapper.SysCodeMapper");
	}
}
