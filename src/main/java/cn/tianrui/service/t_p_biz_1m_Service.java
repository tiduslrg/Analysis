package cn.tianrui.service;

import java.util.List;

import cn.tianrui.mapping.t_p_biz_1m;

public interface t_p_biz_1m_Service {

	void save_t_p_biz_1d(t_p_biz_1m data);

	void deleteDataByID(String ID);

	List<t_p_biz_1m> findAllData();
	
	List<t_p_biz_1m> findTest();

	t_p_biz_1m findDataByID(String ID);
	
	List<t_p_biz_1m> findByData(String date);

}
