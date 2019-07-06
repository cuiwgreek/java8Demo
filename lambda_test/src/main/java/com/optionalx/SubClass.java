package com.optionalx;

import com.day04.MyFun;
import com.day04.MyInterface;

public class SubClass /*extends MyClass*/ implements MyFun, MyInterface{

	@Override
	public String getName() {
		return MyInterface.super.getName();
	}

}
