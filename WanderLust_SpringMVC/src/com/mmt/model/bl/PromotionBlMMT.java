package com.mmt.model.bl;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mmt.model.bean.Promotion;
import com.mmt.model.dao.PromotionDaoImplMMT;
import com.mmt.model.dao.PromotionDaoMMT;
public class PromotionBlMMT {
	private PromotionDaoMMT promotionDao=new PromotionDaoImplMMT();
	
	public int insertPromotion(Promotion p)throws SQLException, ClassNotFoundException, IOException {
		return promotionDao.insertPromotion(p);
	}
	
	public int deletePromotion(String promotionId)throws SQLException, ClassNotFoundException, IOException {
		return promotionDao.deletePromotion(promotionId);
	}
	
	public int updatePromotion(String pId, Promotion newp) throws SQLException, ClassNotFoundException, IOException{
		return promotionDao.updatePromotion(pId,newp);
	}
	
	public ArrayList<Promotion> displayPromotion()throws SQLException, ClassNotFoundException, IOException {
		return promotionDao.displayPromotion();
	}
	
	public ArrayList<Promotion> displayPromotion(String promotionType)throws SQLException, ClassNotFoundException, IOException {
		return promotionDao.displayPromotion(promotionType);
	}
	
	public Promotion searchPromotion(String promotionId) throws SQLException, ClassNotFoundException, IOException{
		return promotionDao.searchPromotion(promotionId);
	}
	
	public double applyPromotion(Promotion p, String userId, double cartValue){
		double finalPrice=0;
		double currentPrice=cartValue;
		if(p==null)
			//System.out.println("No promotions");
			return cartValue;
	//	System.out.println("Promotion: "+p.getPromotionId());
		if((currentPrice-p.getPromotionMinRequiredAmount())>0){
			double discount= (double) ((p.getPromotionDiscount()/100)*currentPrice);
			finalPrice=currentPrice-discount;
			return finalPrice;
		}
		else{
			//Make an Exception // Make logic if cart value is less than minimum required amount
			//System.out.println("Cart Value should be greater than "+p.getPromotionMinRequiredAmount());
			return currentPrice;
		}
	}
	
	
}
