package cn.itcast.jk.dao;

import java.io.Serializable;
import java.util.Map;

import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description:购销合同dao接口
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
public interface ContractDao extends BaseDao<Contract>{
	public void updateState(Map map);		//批量修改状态
	public ContractVO view(Serializable id);		//查看某个购销合同
}
