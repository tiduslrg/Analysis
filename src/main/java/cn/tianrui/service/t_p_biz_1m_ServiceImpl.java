package cn.tianrui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tianrui.dao.t_p_biz_1d_Dao;
import cn.tianrui.mapping.t_p_biz_1m;

@Service("t_p_biz_1m_ServiceImpl")
@Transactional
public class t_p_biz_1m_ServiceImpl implements t_p_biz_1m_Service {

	@Autowired
	private t_p_biz_1d_Dao dao;

	public void save_t_p_biz_1d(t_p_biz_1m data) {
		dao.saveData(data);
	}

	public void deleteDataByID(String ID) {
		dao.deleteDataByID(ID);
	}

	public List<t_p_biz_1m> findAllData() {
		return dao.findAllData();
	}

	public List<t_p_biz_1m> findTest() {
		return dao.findTest();
	}

	public t_p_biz_1m findDataByID(String ID) {
		return dao.findDataByID(ID);
	}

	@Override
	public List<t_p_biz_1m> findByData(String date) {
		return dao.findDataByDate(date);
	}

}
