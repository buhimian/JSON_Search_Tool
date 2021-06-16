package tcs.codeit.jsonsearch.dto;

import org.springframework.stereotype.Component;

@Component
public class JSONSearchRequestDTO {

	private String jsonString;
	private String searchKey;
	
	/**
	 * @return the jsonString
	 */
	public String getJsonString() {
		return jsonString;
	}
	/**
	 * @param jsonString the jsonString to set
	 */
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	/**
	 * @return the searchKey
	 */
	public String getSearchKey() {
		return searchKey;
	}
	/**
	 * @param searchKey the searchKey to set
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
