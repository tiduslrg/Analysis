package cn.tianrui.analyst;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.tianrui.caculation.StandardVariation;
import cn.tianrui.caculation.TianruiPair;
import cn.tianrui.caculation.TianruiQuin;
import cn.tianrui.mapping.VariationAndCofficient;
import cn.tianrui.mapping.t_p_biz_1m;
import cn.tianrui.service.t_f_biz_code_Service;

@Component
@Scope("prototype")
public class Statistics {
	@Autowired
	private t_f_biz_code_Service service;
	@Autowired
	private StandardVariation standardVariation;
	// 1 TIME_TAG 2 GROUP_COUNT 3 REQU_DURA 4 NODE_ID 5 BIZ_CODE
	private Map<Integer, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> NODE_ID_Map;

	private List<VariationAndCofficient> vcList;
	private Date date;

	public Statistics variationByCaculation() {
		Integer keyNode;
		String keyBiz;
		Map<String, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> BIZ_CODE_Map;
		Map<BigInteger, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> TIME_TAG_Map;
		for (Map.Entry<Integer, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> entryNode : NODE_ID_Map
				.entrySet()) {
			keyNode = entryNode.getKey();
			BIZ_CODE_Map = variationByBIZ_CODE_1st(entryNode.getValue());
			for (Map.Entry<String, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> entryBiz : BIZ_CODE_Map
					.entrySet()) {
				keyBiz = entryBiz.getKey();
				TIME_TAG_Map = variationByBIZ_CODE_2nd(entryBiz.getValue());
				vcList.add(variationCaculation(TIME_TAG_Map, keyNode, keyBiz));
			}
		}
		return this;
	}

	private Map<String, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> variationByBIZ_CODE_1st(
			List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>> list) {
		Map<String, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> BIZ_CODE_Map = new TreeMap<String, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>>();
		for (TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String> item : list) {
			if (!BIZ_CODE_Map.containsKey(item.getFifth()))
				BIZ_CODE_Map.put(item.getFifth(),
						new ArrayList<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>());
			BIZ_CODE_Map.get(item.getFifth()).add(item);
		}
		return BIZ_CODE_Map;
	}

	private Map<BigInteger, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> variationByBIZ_CODE_2nd(
			List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>> list) {
		Map<BigInteger, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> TIME_TAG_Map = new TreeMap<BigInteger, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>>();
		for (TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String> item : list) {
			if (!TIME_TAG_Map.containsKey(item.getFirst()))
				TIME_TAG_Map.put(item.getFirst(),
						new ArrayList<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>());
			TIME_TAG_Map.get(item.getFirst()).add(item);
		}
		return TIME_TAG_Map;
	}

	private VariationAndCofficient variationCaculation(
			Map<BigInteger, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> map,
			Integer NODE_ID, String BIZ_CODE) {
		List<TianruiPair<Integer, Double>> variations = new ArrayList<TianruiPair<Integer, Double>>();
		Double sum;
		Integer amount = 0;
		for (Map.Entry<BigInteger, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>> entry : map
				.entrySet()) {
			sum = 0.0;
			amount = 0;
			for (TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String> tianruiQuin : entry.getValue()) {
				sum += tianruiQuin.getThird().doubleValue();
				amount += tianruiQuin.getSecond().intValue();
			}
			variations.add(new TianruiPair<Integer, Double>(amount, sum));

		}
		Double variation = standardVariation.ExpectingStandardDiviation(variations);
		Double cofficent = standardVariation.ExpectionCofficientValue(variations);
		return new VariationAndCofficient(NODE_ID, BIZ_CODE, date, standardVariation.getAmount(), variation, cofficent);
	}

	public Statistics() {
		NODE_ID_Map = new TreeMap<Integer, List<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>>();
		vcList = new ArrayList<VariationAndCofficient>();
	}

	public void setRawData(BigInteger TIME_TAG, BigInteger GROUP_COUNT, BigInteger REQU_DURA, Integer NODE_ID,
			String BIZ_CODE) {
		TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String> data = new TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>(
				TIME_TAG, GROUP_COUNT, REQU_DURA, NODE_ID, BIZ_CODE);
		if (!NODE_ID_Map.containsKey(NODE_ID))
			NODE_ID_Map.put(NODE_ID, new ArrayList<TianruiQuin<BigInteger, BigInteger, BigInteger, Integer, String>>());
		NODE_ID_Map.get(NODE_ID).add(data);
	}

	public void setRawDataList(List<t_p_biz_1m> list) {
		NODE_ID_Map.clear();
		vcList.clear();
		for (t_p_biz_1m item : list) {
			setRawData(item.getTIME_TAG(), item.getGROUP_COUNT(), item.getREQU_DURA(), item.getNODE_ID(),
					item.getBIZ_CODE());

		}
	}

	public Statistics setDate(Date date) {
		this.date = date;
		return this;
	}

	public List<VariationAndCofficient> getVcList() {
		return vcList;
	}

}
