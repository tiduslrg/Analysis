package cn.tianrui.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.tianrui.mapping.t_p_biz_1m;

@Repository("t_p_biz_1d_Dao")
public class t_p_biz_1d_DaoImpl extends AbstractDao<Integer, t_p_biz_1m> implements t_p_biz_1d_Dao {

	public void saveData(t_p_biz_1m data) {
		persist(data);
	}

	public void deleteDataByID(String id) {
		Query query = getSession().createSQLQuery("delete from " + t_p_biz_1m.tableName + " where id = :id");
		query.setString("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<t_p_biz_1m> findAllData() {
		Criteria criteria = createEntityCriteria();
		return (List<t_p_biz_1m>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<t_p_biz_1m> findTest() {
		Criteria criteria = createEntityCriteria();
		criteria.setMaxResults(200);
		return (List<t_p_biz_1m>) criteria.list();
	}

	public t_p_biz_1m findDataByID(String id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (t_p_biz_1m) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<t_p_biz_1m> findDataByDate(String date) {
		Query query = getSession()
				.createSQLQuery("select * from " + t_p_biz_1m.tableName + " where substr(TIME_TAG,1,6) = :date")
				.addEntity(t_p_biz_1m.class);
		query.setString("date", date);
		return (List<t_p_biz_1m>) query.list();
	}

}
