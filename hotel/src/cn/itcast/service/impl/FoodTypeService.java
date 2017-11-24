package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.IFoodTypeDao;
import cn.itcast.dao.impl.FoodTypeDao;
import cn.itcast.entity.FoodType;
import cn.itcast.factory.BeanFactory;
import cn.itcast.service.IFoodTypeService;

/**
 * 3.ҵ���߼���ӿ�ʵ��
 * 
 * @author Jie.Yuan
 * 
 */
public class FoodTypeService implements IFoodTypeService {

	// ����dao
	//private IFoodTypeDao foodTypeDao = new FoodTypeDao();// ����Ĵ���������д����
	// ������������
	private IFoodTypeDao foodTypeDao = BeanFactory.getInstance("foodtypeDao", IFoodTypeDao.class);

	@Override
	public void delete(int id) {

		try {
			foodTypeDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public FoodType findById(int id) {

		try {
			return foodTypeDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll() {
		try {
			return foodTypeDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<FoodType> getAll(String typeName) {

		try {
			return foodTypeDao.getAll(typeName);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(FoodType foodType) {
		try {
			foodTypeDao.save(foodType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(FoodType foodType) {
		try {
			foodTypeDao.update(foodType);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
