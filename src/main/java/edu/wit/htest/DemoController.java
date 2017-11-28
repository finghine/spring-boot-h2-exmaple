package edu.wit.htest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@Autowired
	private DemoRepository demoInfoRepository;

	@RequestMapping("/")
    public String index(ModelMap map){
		map.addAttribute("list", demoInfoRepository.findAll());
		return "index";
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save() {
		// 内存数据库增加操作
		demoInfoRepository.save(new DemoEntity("title1", "content1"));
		demoInfoRepository.save(new DemoEntity("title2", "content2"));
		demoInfoRepository.save(new DemoEntity("title3", "content3"));
		demoInfoRepository.save(new DemoEntity("title4", "content4"));
		demoInfoRepository.save(new DemoEntity("title5", "content5"));
		return "save ok";
	}

	
	@RequestMapping("/findAll")
	@ResponseBody
    public Iterable<DemoEntity> findAll(){
        // 内存数据库查询操作 
       return demoInfoRepository.findAll();
    }
}
