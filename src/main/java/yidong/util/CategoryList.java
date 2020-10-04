package yidong.util;

import yidong.vo.admin.Category;

import java.util.ArrayList;
import java.util.List;


public class CategoryList {

	public static List<Category> sort(List<Category> list1, List<Category> list2){
		
		List<Category> list=new ArrayList<Category>();
		
		for(int i=0;i<list1.size();i++){
			Integer id=list1.get(i).getCid();//一级分类的id
			list.add(list1.get(i));
			for(int j=0;j<list2.size();j++){
				if(list2.get(j).getIdpid().equals(id)){
					list.add(list2.get(j));
				}
			}
		}
		
		
		return list;
		
	}
}
