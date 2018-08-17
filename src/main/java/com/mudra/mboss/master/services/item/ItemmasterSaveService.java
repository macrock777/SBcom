package com.mudra.mboss.master.services.item;

import java.util.Map;
import com.mudra.mboss.master.bean.item.ItemMasterBean;

public interface ItemmasterSaveService {

	Map<String, Object> saveItemMaster(ItemMasterBean itemMasterBean);

}
