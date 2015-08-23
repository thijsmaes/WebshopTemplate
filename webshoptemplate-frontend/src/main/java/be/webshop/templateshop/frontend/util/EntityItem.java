package be.webshop.templateshop.frontend.util;

public class EntityItem implements Comparable {

	private Object[] columnValues;
	private Long pkEntityId;

	public Object[] getColumnValues() {
		return columnValues;
	}

	public EntityItem(Long pkEntityId, Object[] columnValues) {
		this.columnValues = columnValues;
		this.pkEntityId = pkEntityId;
	}
	
	public Long getPkEntityId() {
		return pkEntityId;
	}
	
	@Override
	public int compareTo(Object o) {
		return -1;
	}

}
