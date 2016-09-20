package cn.itcast.jk.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.jk.dao.OutProductDao;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.OutProductService;
import cn.itcast.jk.vo.OutProductExtVO;
import cn.itcast.jk.vo.OutProductVO;

/**
 * @Description: 
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
@Service
public class OutProductServiceImpl implements OutProductService {

	@Autowired
	OutProductDao outProductDao;
	
	public List<OutProductVO> find(Map paraMap) {
		return outProductDao.find(paraMap);
	}
	
	public String findExt(String contractProductId) {
		StringBuilder sBuilder = new StringBuilder();
		List<OutProductExtVO> oList = outProductDao.findExt(contractProductId);

		if(oList==null||oList.size()==0){
			sBuilder.append("无");
		}else{
			for(OutProductExtVO vo : oList){
				sBuilder.append(vo.getName()).append("\n");				//加换行符
			}
			sBuilder.delete(sBuilder.length()-1,sBuilder.length());		//删除最后一个字符
		}
		return sBuilder.toString();
	}	

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#get(java.io.Serializable)
	 */
	public Factory get(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#insert(cn.itcast.jk.domain.Factory)
	 */
	public void insert(Factory entity) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#update(cn.itcast.jk.domain.Factory)
	 */
	public void update(Factory entity) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#deleteById(java.io.Serializable)
	 */
	public void deleteById(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#delete(java.io.Serializable[])
	 */
	public void delete(Serializable[] ids) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see cn.itcast.jk.service.FactoryService#updateState(java.util.Map)
	 */
	public void updateState(Map map) {
		// TODO Auto-generated method stub
		
	}



}
