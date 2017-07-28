package cn.tianrui.caculation;

public class TianruiPair<T, X> {
	private T first;
	private X second;

	public TianruiPair(T first, X second) {
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public X getSecond() {
		return second;
	}

	public TianruiPair<T, X> setFirst(T first) {
		this.first = first;
		return this;
	}

	public TianruiPair<T, X> setSecond(X second) {
		this.second = second;
		return this;
	}
}
