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
import cn.itcast.jk.domain.ContractProduct;
import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.ContractProductService;

/**
 * @Description: 货物信息
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
@Controller
public class ContractProductController extends BaseController {
	@Autowired
	ContractProductService contractProductService;

	@RequestMapping("/cargo/contractproduct/tocreate.action")
	public String tocreate(String contractId, Model model){			//往一个合同下新增货物信息
		//准备生产厂家下来列表数据
		List<Factory> factoryList = contractProductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		//准备列表数据
		Map paraMap = new HashMap();
		paraMap.put("contractId", contractId);						//某一个合同下的货物信息
		List<ContractProduct> dataList = contractProductService.find(paraMap );
		model.addAttribute("dataList", dataList);
		
		model.addAttribute("contractId", contractId);
		return "/cargo/contract/jContractProductCreate.jsp";
	}
	
	@RequestMapping("/cargo/contractproduct/insert.action")
	public String insert(ContractProduct contractProduct, Model model){
		contractProduct.setId(UUID.randomUUID().toString());
		//计算金额 = 数量*单价
		contractProduct.setAmount(contractProduct.getCnumber()*contractProduct.getPrice());
		
		contractProductService.insert(contractProduct);
		
		model.addAttribute("contractId", contractProduct.getContractId());
		return "redirect:/cargo/contractproduct/tocreate.action";		//新增后返回到新增页面；批量新增（子表）
	}
	
	@RequestMapping("/cargo/contractproduct/toupdate.action")
	public String toupdate(String id, Model model){
		//准备生产厂家下来列表数据
		List<Factory> factoryList = contractProductService.getFactoryList();
		model.addAttribute("factoryList", factoryList);
		
		ContractProduct obj = contractProductService.get(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractProductUpdate.jsp";
	}
	
	@RequestMapping("/cargo/contractproduct/update.action")
	public String update(ContractProduct contractProduct){
		contractProductService.update(contractProduct);
		
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
	
	@RequestMapping("/cargo/contractproduct/deleteById.action")
	public String deleteById(String id,String contractId, Model model){
		contractProductService.deleteById(id);
		
		model.addAttribute("contractId", contractId);
		return "redirect:/cargo/contractproduct/tocreate.action";
	}
}
