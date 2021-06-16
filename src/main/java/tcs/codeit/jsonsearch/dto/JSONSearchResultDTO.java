package tcs.codeit.jsonsearch.dto;

import org.springframework.stereotype.Component;

@Component
public class JSONSearchResultDTO {

	@Override
	public String toString() {
		return "JSONSearchResultDTO [key=" + key + ", level=" + level + ", parent=" + parent + "]";
	}
	
	private String key;
	private String path; 
	private String dataType;
	private String level;
	private String parent;
	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}
	/**
	 * @param parent the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the value
	 */
	public String getDataType() {
		return dataType;
	}
	/**
	 * @param value the value to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
}
