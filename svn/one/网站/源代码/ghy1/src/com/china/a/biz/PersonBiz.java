package com.china.a.biz;

import java.util.List;

import com.china.a.dao.Logindao;
import com.china.a.vo.Person;

public class PersonBiz {

	public List<Person> getFenyePerson(int start ,int end) {
		Logindao logindao=new Logindao();
		return logindao.getFenyePerson(start, end);
	}
}
