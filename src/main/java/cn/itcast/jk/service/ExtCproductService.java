package cn.itcast.jk.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.domain.SysCode;

/**
 * @Description: 附件service接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
public interface ExtCproductService {
	public List<ExtCproduct> find(Map paraMap);
	public ExtCproduct get(Serializable id);
	public void insert(ExtCproduct entity);
	public void update(ExtCproduct entity);
	public void deleteById(Serializable id);
	public void delete(Serializable[] ids);
	
	public List<Factory> getFactoryList();		//获取生产厂家下拉列表
	public List<SysCode> getSysCodeList();		//获取基础信息之附件类型下拉列表
}
