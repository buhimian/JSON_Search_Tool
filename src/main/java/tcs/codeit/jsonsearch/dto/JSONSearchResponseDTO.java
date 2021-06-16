package tcs.codeit.jsonsearch.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class JSONSearchResponseDTO {
	
	private String numberOfOccurances;
	private List<JSONSearchResultDTO> searchResult;
	
	/**
	 * @return the numberOfOccurances
	 */
	public String getNumberOfOccurances() {
		return numberOfOccurances;
	}
	/**
	 * @param numberOfOccurances the numberOfOccurances to set
	 */
	public void setNumberOfOccurances(String numberOfOccurances) {
		this.numberOfOccurances = numberOfOccurances;
	}
	/**
	 * @return the searchResult
	 */
	public List<JSONSearchResultDTO> getSearchResult() {
		return searchResult;
	}
	/**
	 * @param searchResult the searchResult to set
	 */
	public void setSearchResult(List<JSONSearchResultDTO> searchResult) {
		this.searchResult = searchResult;
	}

}
