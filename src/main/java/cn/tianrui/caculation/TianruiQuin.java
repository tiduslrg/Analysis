package cn.tianrui.caculation;

public class TianruiQuin<T, X, Y, Z, F> {
	private T first;
	private X second;
	private Y third;
	private Z fourth;
	private F fifth;

	public TianruiQuin(T first, X second, Y third, Z fourth, F fifth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
	}

	public T getFirst() {
		return first;
	}

	public X getSecond() {
		return second;
	}

	public Y getThird() {
		return third;
	}

	public Z getFourth() {
		return fourth;
	}

	public F getFifth() {
		return fifth;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(X second) {
		this.second = second;
	}

	public void setThird(Y third) {
		this.third = third;
	}

	public void setFourth(Z fourth) {
		this.fourth = fourth;
	}

	public void setFifth(F fifth) {
		this.fifth = fifth;
	}


}
