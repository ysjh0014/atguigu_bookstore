package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.FoodType;

/**
 * 3. ��ϵģ��ҵ���߼��㣬�ӿ����
 * @author Jie.Yuan
 *
 */
public interface IFoodTypeService {


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









