package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 2. ��ϵģ�飬dao�ӿ����
 * @author Jie.Yuan
 *
 */
public interface IFoodTypeDao {

	/**
	 * ���
	 */
	void save(FoodType foodType);
	
	/**
	 * ����
	 */
	void update(FoodType foodType);
	
	/**
	 * ɾ��
	 */
	void delete(int id);
	
	/**
	 * ����������ѯ
	 */
	FoodType findById(int id);
	
	/**
	 * ��ѯȫ��
	 */
	List<FoodType> getAll();
	
	/**
	 * ���ݲ�ϵ���Ʋ�ѯ
	 */
	List<FoodType> getAll(String typeName);
	
	
}








