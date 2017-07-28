package cn.tianrui.caculation;

public class TianruiQuad<T, X, Y, Z> {
	private T first;
	private X second;
	private Y third;
	private Z fourth;

	public TianruiQuad(T first, X second, Y third, Z fourth) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
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
}
