package cn.tianrui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tianrui.dao.t_f_biz_code_Dao;
import cn.tianrui.mapping.t_f_biz_code;

@Service("t_f_biz_code_Service")
@Transactional
public class t_f_biz_code_ServiceImpl implements t_f_biz_code_Service {

	@Autowired
	private t_f_biz_code_Dao dao;

	public List<t_f_biz_code> findAllData() {
		return dao.findAllData();
	}

}
