package com.kevll.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kevin
 * @date 2018年3月12日
 * 包装一个对象的所有属性值
 */
public class PropertyValues {
	private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

	public PropertyValues() {
	}

	public void addPropertyValue(PropertyValue pv) {
		this.propertyValueList.add(pv);
	}

	public List<PropertyValue> getPropertyValues() {
		return this.propertyValueList;
	}

}
