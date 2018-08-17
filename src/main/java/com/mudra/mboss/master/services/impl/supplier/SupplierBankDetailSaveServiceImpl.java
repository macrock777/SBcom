package com.mudra.mboss.master.services.impl.supplier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mudra.mboss.master.bean.client.MasterCommon;
import com.mudra.mboss.master.bean.supplier.SupplierBankDetailBean;
import com.mudra.mboss.master.entity.supplier.Suppliermasterrtgsdetail;
import com.mudra.mboss.master.entity.supplier.SuppliermasterrtgsdetailId;
import com.mudra.mboss.master.services.supplier.SupplierBankDetailSaveService;

@Service
public class SupplierBankDetailSaveServiceImpl implements SupplierBankDetailSaveService
{
	@Autowired
	EntityManagerFactory emf;

	@Override
	public Map<String, Object> saveSupplierBankdetailData(SupplierBankDetailBean bean) {
		Map<String, Object> map = new HashMap<String, Object>();
		Transaction transaction =null;
		Session session = emf.createEntityManager().unwrap(Session.class);
		try{
			String uniqueid = bean.getUniqueid();
		
			if (MasterCommon.checkNullAndEmpty(bean.getSupplierid(),uniqueid)) {
				transaction = session.beginTransaction();
				Suppliermasterrtgsdetail suppliermasterrtgsdetail = new Suppliermasterrtgsdetail();
				SuppliermasterrtgsdetailId id = new SuppliermasterrtgsdetailId();
				String strQuery = "select supplierid from MUDRA.SUPPLIERMASTERRTGSDETAIL where uniqueid ="+bean.getUniqueid()+" and supplierid ='"+bean.getSupplierid()+"'";
				List<?> list  = getDataFromQuery(strQuery, session);
				if(null!=list && list.size()>0) {
					id.setSupplierid(bean.getSupplierid());
					id.setUniqueid(Integer.parseInt(uniqueid));
					suppliermasterrtgsdetail = (Suppliermasterrtgsdetail)session.get(Suppliermasterrtgsdetail.class, id);
				}
				else {
					id.setSupplierid(bean.getSupplierid());
					id.setUniqueid(Integer.parseInt(uniqueid));
					suppliermasterrtgsdetail.setId(id);
				}

				if(null!=bean.getBeneficiaryname() && bean.getBeneficiaryname().trim().length()>0)
					suppliermasterrtgsdetail.setBeneficiaryname(bean.getBeneficiaryname().trim());
				if(null!=bean.getAccountnumber() && bean.getAccountnumber().trim().length()>0)
					suppliermasterrtgsdetail.setAccountnumber(bean.getAccountnumber().trim());
				if(null!=bean.getIfsccode() && bean.getIfsccode().trim().length()>0)
					suppliermasterrtgsdetail.setIfsccode(bean.getIfsccode().trim());
				if(null!=bean.getBankname() && bean.getBankname().trim().length()>0)
					suppliermasterrtgsdetail.setBankname(bean.getBankname().trim());
				if(null!=bean.getBranchname() && bean.getBranchname().trim().length()>0)
					suppliermasterrtgsdetail.setBranchname(bean.getBranchname().trim());
				if(null!=bean.getBenedescription() && bean.getBenedescription().trim().length()>0)
					suppliermasterrtgsdetail.setBenedescription(bean.getBenedescription().trim());
				
				if(bean.getIsEdit().equalsIgnoreCase("no"))
					session.save(suppliermasterrtgsdetail);
				
				session.flush();
				map.put("SAVE", "SUCCESSFULLY");
				transaction.commit();
			}
			
		}
		catch(Exception e){
			if(null!=transaction) {
				System.out.println("Transaction Rollback");
				transaction.rollback();
			}
			map.put("ERRORMASSAGE","Error occur During The Save Data Please Contact ( IT )");
			e.printStackTrace();
		}
		finally{
			if(null!=session) {
				session.clear();
				session.close();
			}	
		}
		return map;
	}
	
	
	public List<?> getDataFromQuery(String strQuery,Session session) {
		try {
			Query query = session.createNativeQuery(strQuery);
			List<?> dataList = query.getResultList();
			return dataList;
		} catch (Exception ex) {
	   }
	  return null;
    }
	
	
		
	
	
}
