package be.webshop.templateshop.frontend.util;

import java.util.TreeSet;

public class EntityList extends TreeSet<EntityItem> {

	private String[] columnNames;
	private Class[] columnTypes;

	public EntityList(String[] columnNames, Class[] columnTypes) {
		this.columnNames = columnNames;
		this.columnTypes = columnTypes;
	}
	
	public String[] getColumnNames() {
		return columnNames;
	}
	
	public Class[] getColumnTypes() {
		return columnTypes;
	}
}
