package cn.itcast.jk.service;

import java.util.List;
import java.util.Map;

import cn.itcast.jk.vo.OutProductExtVO;
import cn.itcast.jk.vo.OutProductVO;

/**
 * @Description: 生产厂家业务接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
public interface OutProductService {
	public List<OutProductVO> find(Map paraMap);
	public String findExt(String contractProductId);
}
