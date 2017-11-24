package ����;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * �����������DAO<T>,�����ж���һ��Map��Ա������Map�ļ�ΪString���ͣ�ֵΪT����
 * 
 * �ֱ𴴽����·�����
 * public void save(String id,T entity),����T���͵Ķ���Map��Ա������
 * T get(String id):��map�л�ȡid��Ӧ�Ķ���
 * void update(String id,T entity):�滻map��keyΪid�����ݣ���Ϊentity����
 * List<T>list():����map�д�ŵ�����T����
 * void delete(String id):ɾ��ָ����id����
 */
public class DAO<T> {
Map<String,T>map=new HashMap<>();

public void save(String id,T entity){
map.put(id, entity);	
}
public T get(String id){
	return map.get(id);
}
public void update(String id,T entity){
	map.put(id, entity);
}
public List<T>list(){
	List<T>list1=new ArrayList<>();
	for(String s:map.keySet()){
		list1.add(map.get(s));
	}
	return list1;
}
public void delete(String id){
	map.remove(id);
}
}
