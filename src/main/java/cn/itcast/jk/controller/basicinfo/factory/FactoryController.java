package cn.itcast.jk.controller.basicinfo.factory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.jk.domain.Factory;
import cn.itcast.jk.service.FactoryService;

/**
 * @Description:
 * @Author:	nutony
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-1
 */
@Controller
public class FactoryController {
	@Autowired
	FactoryService factoryService;
	
	//查询
	@RequestMapping("/basicinfo/factory/list.action")
	public String list(Model model){
//		Map paraMap = new HashMap();
//		paraMap.put("state", 1);
//		
		List<Factory> dataList = factoryService.find(null);
		model.addAttribute("dataList", dataList);
		
		return "/basicinfo/factory/jFactoryList.jsp";
	}
	
	//转向新增页面
	@RequestMapping("/basicinfo/factory/tocreate.action")
	public String tocreate(){
		return "/basicinfo/factory/jFactoryCreate.jsp";
	}
	
	//新增保存
	@RequestMapping("/basicinfo/factory/insert.action")
	public String insert(Factory factory){
		//加工数据
		factory.setId(UUID.randomUUID().toString());		//产生一个UUID
		factory.setCreateTime(new java.util.Date());
		factory.setState("1");								//1启用0停用								
		
		factoryService.insert(factory);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//转向修改页面
	@RequestMapping("/basicinfo/factory/toupdate.action")
	public String toupdate(String id, Model model){
		Factory factory = factoryService.get(id);
		model.addAttribute("obj", factory);
		
		return "/basicinfo/factory/jFactoryUpdate.jsp";
	}
	
	//修改保存
	@RequestMapping("/basicinfo/factory/update.action")
	public String update(Factory factory){
		factoryService.update(factory);
		
		return "redirect:/basicinfo/factory/list.action";
	}

	//删除
	@RequestMapping("/basicinfo/factory/deleteById.action")
	public String deleteById(String id){
		factoryService.deleteById(id);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//批量删除
	@RequestMapping("/basicinfo/factory/delete.action")
	public String delete(String[] id){
		factoryService.delete(id);
		
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//转向查看页面
	@RequestMapping("/basicinfo/factory/toview.action")
	public String toview(String id, Model model){
		Factory factory = factoryService.get(id);
		model.addAttribute("obj", factory);
		
		return "/basicinfo/factory/jFactoryView.jsp";
	}
	
	//启用，状态1
	@RequestMapping("/basicinfo/factory/start.action")
	public String start(String[] id){
		this.updateState(id, "1");
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//停用，状态0
	@RequestMapping("/basicinfo/factory/stop.action")
	public String stop(String[] id){
		this.updateState(id, "0");
		return "redirect:/basicinfo/factory/list.action";
	}
	
	//修改状态：1启用0停用
	private void updateState(String[] id, String value){
		Map map = new HashMap();		//条件
		map.put("ids", id);
		map.put("state", value);
		
		factoryService.updateState(map);
	}
}
