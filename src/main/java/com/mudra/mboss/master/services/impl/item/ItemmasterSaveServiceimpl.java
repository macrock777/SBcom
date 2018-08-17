package com.mudra.mboss.master.services.impl.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mudra.mboss.master.bean.MasterCommon;
import com.mudra.mboss.master.bean.item.ItemMasterBean;
import com.mudra.mboss.master.entity.item.Itemmaster;
import com.mudra.mboss.master.entity.item.ItemmasterId;
import com.mudra.mboss.master.services.item.ItemmasterSaveService;

@Service
public class ItemmasterSaveServiceimpl implements ItemmasterSaveService {

	@Autowired
	EntityManagerFactory emf;

	@Override
	public Map<String, Object> saveItemMaster(ItemMasterBean itemMasterBean) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = emf.createEntityManager().unwrap(Session.class);
		Transaction transaction = session.beginTransaction();
		try {
			String groupitemcode = itemMasterBean.getGroupitemcode();
			String itemcode = itemMasterBean.getItemcode();
			String stokeorservice = itemMasterBean.getStockoreservice();
			String incomeglcode = itemMasterBean.getIncomeglcode();
			String defaultunit = itemMasterBean.getDefaultunit();
			String expenseglcode = itemMasterBean.getExpenseglcode();
			String itemdescription = itemMasterBean.getItemdescription();
			String isedititem = itemMasterBean.getIseditItem();

			if (MasterCommon.checkNullAndEmpty(groupitemcode, itemcode)) {

				String SqlQuery = "select count(1) from mudra.itemmaster where Upper(GROUPITEMCODE)='" + groupitemcode.toUpperCase() + "' and Upper(ITEMCODE)='" + itemcode.toUpperCase() + "'";
				Query query = session.createNativeQuery(SqlQuery);
				List<?> list = query.getResultList();
				int count = Integer.parseInt(list.get(0).toString());
				if (count > 0 && isedititem.equalsIgnoreCase("NO")) {
					map.put("DUPLICATE", "Data Already Exist");
					transaction.rollback();
					return map;
				}

				Itemmaster itemmaster = new Itemmaster();
				ItemmasterId id = new ItemmasterId();

				id.setGroupitemcode(groupitemcode.trim());
				id.setItemcode(itemcode.trim());

				itemmaster.setId(id);

				if (isedititem.equalsIgnoreCase("YES")) {
					itemmaster = (Itemmaster) session.get(Itemmaster.class, id);
				}

				if (MasterCommon.checkNullAndEmpty(stokeorservice))
					itemmaster.setStockorservice(stokeorservice.trim());
				else
					itemmaster.setStockorservice("");
				if (MasterCommon.checkNullAndEmpty(incomeglcode))
					itemmaster.setIncomeglcode(incomeglcode.trim());
				if (MasterCommon.checkNullAndEmpty(defaultunit))
					itemmaster.setDefaultunit(defaultunit.trim());
				else
					itemmaster.setDefaultunit("");
				if (MasterCommon.checkNullAndEmpty(expenseglcode))
					itemmaster.setExpenseglcode(expenseglcode.trim());
				if (MasterCommon.checkNullAndEmpty(itemdescription))
					itemmaster.setItemdescription(itemdescription.trim());
				else
					itemmaster.setItemdescription("");
				itemmaster.setServicetaxglcode("0");
				itemmaster.setVatglcode("0");
				itemmaster.setCstglcode("0");
				itemmaster.setInputvatglcode("0");
				itemmaster.setLocalvatglcode("0");
				itemmaster.setIsactive("Y");
				if (isedititem.equalsIgnoreCase("NO"))
					session.save(itemmaster);
				session.flush();
				map.put("SAVE", "SUCCESSFULLY");
				transaction.commit();
			} else {
				map.put("REQUIRED_FIELD", "Error occure during save data please contact It.");
				transaction.rollback();
			}
		} catch (Exception e) {
			if (null != transaction) {
				System.out.println("Transaction Rollback");
				transaction.rollback();
			}
			map.put("ERRORMASSAGE", "Error occure during save data please contact It.");
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.clear();
				session.close();
			}
		}
		return map;
	}
}
