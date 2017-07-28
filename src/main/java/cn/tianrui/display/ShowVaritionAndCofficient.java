package cn.tianrui.display;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.tianrui.mapping.VariationAndCofficient;
import cn.tianrui.mapping.t_f_biz_code;
import cn.tianrui.service.t_f_biz_code_Service;

@Component
@Scope("prototype")
public class ShowVaritionAndCofficient {
	@Autowired
	private t_f_biz_code_Service service;
	// Map<NODE_ID, Map<BIZ_CODE, VariationAndCofficient>>
	private Map<Integer, Map<String, Set<VariationAndCofficient>>> mapByBiz;
	// Map<BIZ_ID, BIZ_NAME>
	private Map<String, String> mappingMap;
	private Set<VariationAndCofficient> vcSet = new HashSet<VariationAndCofficient>();
	private DecimalFormat varitionFormat = new DecimalFormat("0.00000");
	private DecimalFormat cofficientFormat = new DecimalFormat("0.00000");
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public void showVCinConsole() {
		for (Map.Entry<Integer, Map<String, Set<VariationAndCofficient>>> entry : mapByBiz.entrySet()) {
			System.out.println(entry.getKey());
			for (Map.Entry<String, Set<VariationAndCofficient>> entryIn : entry.getValue().entrySet()) {
				System.out.println("\t\t" + entryIn.getKey() + "--" + getBiz_NameByBiz_ID(entryIn.getKey()));
				for (VariationAndCofficient vc : entryIn.getValue()) {
					System.out.println("\t\t\t\t" + sdf.format(vc.getDATE()) + "\t\t" + vc.getAMOUNT() + "\t\t"
							+ varitionFormat.format(vc.getVARIANCE()) + "\t\t"
							+ cofficientFormat.format(vc.getCOFFICIENT()));
				}
			}
		}
	}

	public List<VariationAndCofficient> showVCinWeb() {
		List<VariationAndCofficient> vcList = new ArrayList<VariationAndCofficient>();
		for (Map.Entry<Integer, Map<String, Set<VariationAndCofficient>>> entry : mapByBiz.entrySet()) {
			for (Map.Entry<String, Set<VariationAndCofficient>> entryIn : entry.getValue().entrySet()) {
				for (VariationAndCofficient vc : entryIn.getValue()) {
					vcList.add(new VariationAndCofficient(entry.getKey(), getBiz_NameByBiz_ID(entryIn.getKey()),
							vc.getDATE(), new Integer(vc.getAMOUNT().intValue()),
							new Double(varitionFormat.format(vc.getVARIANCE())),
							new Double(cofficientFormat.format(vc.getCOFFICIENT()))));

				}
			}
		}
		return vcList;
	}

	public ShowVaritionAndCofficient() {
		mapByBiz = new HashMap<Integer, Map<String, Set<VariationAndCofficient>>>();
		mappingMap = new HashMap<String, String>();
	}

	public ShowVaritionAndCofficient caculate() {
		for (VariationAndCofficient vc : vcSet) {
			setMapByBiz(vc);
		}
		return this;
	}

	private ShowVaritionAndCofficient setMapByBiz(VariationAndCofficient vc) {
		if (!mapByBiz.containsKey(vc.getNODE_ID())) {
			mapByBiz.put(vc.getNODE_ID(), new HashMap<String, Set<VariationAndCofficient>>());
		}
		Map<String, Set<VariationAndCofficient>> map = mapByBiz.get(vc.getNODE_ID());
		if (!map.containsKey(vc.getBIZ_CODE())) {
			map.put(vc.getBIZ_CODE(), new TreeSet<VariationAndCofficient>());
		}
		map.get(vc.getBIZ_CODE()).add(vc);
		return this;
	}

	private String getBiz_NameByBiz_ID(String biz_node) {
		for (Map.Entry<String, String> entryIn : mappingMap.entrySet()) {
			if (biz_node.equals(entryIn.getKey())) {
				return entryIn.getValue();
			}
		}
		return biz_node;
	}

	public void initialize(List<VariationAndCofficient> vcList) {
		for (t_f_biz_code item : service.findAllData()) {
			if (!mappingMap.containsKey(item.getBIZ_CODE())) {
				mappingMap.put(item.getBIZ_CODE(), item.getBIZ_NAME());
			}
		}
		vcSet.addAll(vcList);
	}
}
