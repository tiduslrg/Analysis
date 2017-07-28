package cn.tianrui.caculation;

public class TianruiTriple<T, X, Y> {
	private T first;
	private X second;
	private Y third;

	public TianruiTriple(T first, X second, Y third) {
		super();
		this.first = first;
		this.second = second;
		this.third = third;
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
}
