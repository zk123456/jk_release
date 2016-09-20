package cn.itcast.jk.controller.cargo.contract;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.ExtCproduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.domain.SysCode;
import cn.itcast.jk.service.ExtCproductService;

/**
 * @Description: 附件信息
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
@Controller
public class ExtCproductController extends BaseController {
	@Autowired
	ExtCproductService extCproductService;

	@RequestMapping("/cargo/extcproduct/tocreate.action")
	public String tocreate(String contractProductId, Model model){			//往一个货物下新增附件信息
		//准备生产厂家下列表数据
		List<Factory> factoryList = extCproductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//准备分类下拉列表
		List<SysCode> ctypeList = extCproductService.getSysCodeList();
		model.addAttribute("ctypeList", ctypeList);
		
		//准备列表数据
		Map paraMap = new HashMap();
		paraMap.put("contractProductId", contractProductId);				//某一个货物下的附件信息
		List<ExtCproduct> dataList = extCproductService.find(paraMap );
		model.addAttribute("dataList", dataList);
		
		model.addAttribute("contractProductId", contractProductId);
		return "/cargo/contract/jExtCproductCreate.jsp";
	}
	
	@RequestMapping("/cargo/extcproduct/insert.action")
	public String insert(ExtCproduct extCproduct, Model model){
		extCproduct.setId(UUID.randomUUID().toString());
		extCproductService.insert(extCproduct);
		
		model.addAttribute("contractProductId", extCproduct.getContractProductId());
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/extcproduct/toupdate.action")
	public String toupdate(String id, String contractProductId, Model model){
		//准备生产厂家下来列表数据
		List<Factory> factoryList = extCproductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//准备分类下拉列表
		List<SysCode> ctypeList = extCproductService.getSysCodeList();
		model.addAttribute("ctypeList", ctypeList);		
		
		ExtCproduct obj = extCproductService.get(id);
		model.addAttribute("obj", obj);
				
		model.addAttribute("contractProductId", contractProductId);
		return "/cargo/contract/jExtCproductUpdate.jsp";		
	}
	
	@RequestMapping("/cargo/extcproduct/update.action")
	public String update(ExtCproduct extCproduct, Model model){
		extCproductService.update(extCproduct);
		
		model.addAttribute("contractProductId", extCproduct.getContractProductId());
		return "redirect:/cargo/extcproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/extcproduct/deleteById.action")
	public String deleteById(String id, String contractProductId, Model model){
		extCproductService.deleteById(id);
		
		model.addAttribute("contractProductId", contractProductId);
		return "redirect:/cargo/extcproduct/tocreate.action";
	}

}
