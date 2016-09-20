package cn.itcast.jk.dao;

import java.util.List;
import java.util.Map;

import cn.itcast.jk.vo.OutProductExtVO;
import cn.itcast.jk.vo.OutProductVO;

/**
 * @Description:生产厂家的dao接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
public interface OutProductDao{
	public List<OutProductVO> find(Map paraMap);
	public List<OutProductExtVO> findExt(String contractProductId);
}
