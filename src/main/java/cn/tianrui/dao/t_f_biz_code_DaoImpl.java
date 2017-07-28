package cn.tianrui.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.tianrui.mapping.t_f_biz_code;

@Repository("t_f_biz_code_Dao")
public class t_f_biz_code_DaoImpl extends AbstractDao<Integer, t_f_biz_code> implements t_f_biz_code_Dao {

	@Override
	@SuppressWarnings("unchecked")
	public List<t_f_biz_code> findAllData() {
		Criteria criteria = createEntityCriteria();
		return (List<t_f_biz_code>) criteria.list();
	}

}
