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
import cn.itcast.jk.domain.Contract;
import cn.itcast.jk.service.ContractService;
import cn.itcast.jk.vo.ContractVO;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-4
 */
@Controller
public class ContractController extends BaseController {
	@Autowired
	ContractService contractService;
	
	@RequestMapping("/cargo/contract/list.action")
	public String list(Model model){
		List<Contract> dataList = contractService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/cargo/contract/jContractList.jsp";
	}
	
	@RequestMapping("/cargo/contract/tocreate.action")
	public String tocreate(){
		return "/cargo/contract/jContractCreate.jsp";
	}
	
	@RequestMapping("/cargo/contract/insert.action")
	public String insert(Contract contract){
		contract.setId(UUID.randomUUID().toString());
		contract.setState(0);			//0未上报，1已上报
		contractService.insert(contract);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/toupdate.action")
	public String toupdate(String id, Model model){
		Contract obj = contractService.get(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractUpdate.jsp";
	}
	
	@RequestMapping("/cargo/contract/update.action")
	public String update(Contract contract){
		contractService.update(contract);
		return "redirect:/cargo/contract/list.action";
	}
	
	@RequestMapping("/cargo/contract/delete.action")
	public String delete(String[] id){
		contractService.delete(id);
		return "redirect:/cargo/contract/list.action";
	}
	
	
	//上报，状态1
	@RequestMapping("/cargo/contract/submit.action")
	public String submit(String[] id){
		this.updateState(id, "1");
		return "redirect:/cargo/contract/list.action";
	}
	
	//取消，状态0
	@RequestMapping("/cargo/contract/cancel.action")
	public String cancel(String[] id){
		this.updateState(id, "0");
		return "redirect:/cargo/contract/list.action";
	}
	
	//修改状态：0未上报1已上报
	private void updateState(String[] id, String value){
		Map map = new HashMap();		//条件
		map.put("ids", id);
		map.put("state", value);
		
		contractService.updateState(map);
	}	
	
	//查看
	@RequestMapping("/cargo/contract/toview.action")
	public String toview(String id, Model model){
		ContractVO obj = contractService.view(id);
		model.addAttribute("obj", obj);
		
		return "/cargo/contract/jContractView.jsp";
	}
}
