import cn.tianrui.caculation.TianruiDate;
import junit.framework.TestCase;

public class DateTest extends TestCase {

	private TianruiDate dateStart;
	
	protected void setUp() throws Exception {
		super.setUp();
		dateStart = new TianruiDate("20170626");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testShortDate() {
	System.out.println(dateStart.getCurrentDateFormatted());
	}

}
