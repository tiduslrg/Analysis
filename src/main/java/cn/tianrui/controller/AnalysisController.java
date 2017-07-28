package cn.tianrui.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.tianrui.analyst.Statistics;
import cn.tianrui.caculation.TianruiDate;
import cn.tianrui.display.ShowVaritionAndCofficient;
import cn.tianrui.mapping.VariationAndCofficient;
import cn.tianrui.mapping.t_f_biz_code;
import cn.tianrui.mapping.t_p_biz_1m;
import cn.tianrui.service.t_f_biz_code_Service;
import cn.tianrui.service.t_p_biz_1m_Service;

@Controller
@RequestMapping("/")
public class AnalysisController {

	@Autowired
	private t_p_biz_1m_Service service;

	@Autowired
	private Statistics statistics;

	@Autowired
	private ShowVaritionAndCofficient showVC;

	@Autowired
	private MessageSource messageSource;

	boolean run = false;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listData(ModelMap model) {
		if (!run) {
			TianruiDate dateStart = new TianruiDate("20170601");
			TianruiDate dateEnd = new TianruiDate("20170630");
			for (; dateStart.getCurrentDate().compareTo(dateEnd.getCurrentDate()) <= 0; dateStart.IncreaseDays(1)) {
				statistics.setDate(dateStart.getCurrentDate());
				statistics.setRawDataList(service.findByData(dateStart.getShortCurrentDate()));
				showVC.initialize(statistics.variationByCaculation().getVcList());
			}
			showVC.caculate();
			showVC.showVCinConsole();
			List<VariationAndCofficient> data = showVC.showVCinWeb();
			model.addAttribute("data", data);
			run = true;
		}
		return "alldata";
	}

}
