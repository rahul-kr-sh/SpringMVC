package com.mmt.model.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mmt.model.bean.Promotion;
public interface PromotionDaoMMT {
	int insertPromotion(Promotion p) throws SQLException, ClassNotFoundException, IOException  ;
	int deletePromotion(String promotionId)throws SQLException, ClassNotFoundException, IOException;
	int updatePromotion(String promotionId,Promotion newPromotion)throws SQLException, ClassNotFoundException, IOException;
	ArrayList<Promotion> displayPromotion() throws SQLException, ClassNotFoundException, IOException;
	Promotion searchPromotion(String promotionId)throws SQLException, ClassNotFoundException, IOException ;
	ArrayList<Promotion> displayPromotion(String promotionType) throws SQLException, ClassNotFoundException, IOException;
}
