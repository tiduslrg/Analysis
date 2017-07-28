package cn.tianrui.caculation;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StandardVariation {
	private Integer amount = new Integer(0);
	// <数量，数值>
	public double ExpectingStandardDiviation(List<TianruiPair<Integer, Double>> list) {
		initialize();
		TianruiPair<Integer, Double> amountAndException = Expection(list);
		Double variation = 0.0;
		for (TianruiPair<Integer, Double> item : list) {
			variation += Math.pow(item.getSecond() - amountAndException.getSecond(), 2)
					* ((double) item.getFirst() / (double)amountAndException.getFirst());
//			System.out.println(variation+"\t"+amountAndException.getFirst()+"\t"+amountAndException.getSecond());
		}
		return Math.sqrt(variation);
	}

	// <数量，数值>
	public double ExpectionCofficientValue(List<TianruiPair<Integer, Double>> list) {
		initialize();
		Double variation = this.ExpectingStandardDiviation(list);
		TianruiPair<Integer, Double> amountAndException = Expection(list);
		return variation / amountAndException.getSecond();
	}

	// <数量，数值>
	public double AverageStandardDiviation(List<TianruiPair<Integer, Double>> list) {
		TianruiPair<Integer, Double> amountAndException = Expection(list);
		Double variation = 0.0;
		for (TianruiPair<Integer, Double> item : list) {
			variation += Math.pow(item.getSecond() - amountAndException.getSecond(), 2);
		}
		return Math.sqrt(variation / amountAndException.getFirst());
	}

	// <数量，数值>
	public double AverageCofficientValue(List<TianruiPair<Integer, Double>> list) {
		Double variation = this.AverageStandardDiviation(list);
		TianruiPair<Integer, Double> amountAndException = Expection(list);
		return variation / amountAndException.getSecond();
	}

	private TianruiPair<Integer, Double> Expection(List<TianruiPair<Integer, Double>> list) {	
		for (TianruiPair<Integer, Double> item : list) {
			amount += item.getFirst();
		}
		Double expectionRatio = 0.0;
		Double expection = 0.0;
		for (TianruiPair<Integer, Double> item : list) {
			expectionRatio = item.getFirst() / (double) amount;
			expection += (item.getSecond() / item.getFirst()) * expectionRatio;
		}
		return new TianruiPair<Integer, Double>(amount, expection);
	}

	private void initialize(){
		amount=0;
	}
	public Integer getAmount() {
		return amount;
	}
}
