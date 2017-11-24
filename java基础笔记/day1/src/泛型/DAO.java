package 泛型;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 定义个泛型类DAO<T>,在其中定义一个Map成员变量，Map的键为String类型，值为T类型
 * 
 * 分别创建以下方法：
 * public void save(String id,T entity),保存T类型的对象Map成员变量中
 * T get(String id):从map中获取id对应的对象
 * void update(String id,T entity):替换map中key为id的内容，改为entity对象
 * List<T>list():返回map中存放的所有T对象
 * void delete(String id):删除指定的id对象
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
