package tcs.codeit.jsonsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tcs.codeit.jsonsearch.dto.JSONSearchRequestDTO;
import tcs.codeit.jsonsearch.dto.JSONSearchResponseDTO;
import tcs.codeit.jsonsearch.dto.JSONSearchResultDTO;
import tcs.codeit.jsonsearch.service.JSONSearchService;

@RequestMapping("/JSONSearch")
@RestController
public class JSONSearchController {
	
	@Autowired
	JSONSearchService jsonSearchService;
	
	@PostMapping("/getOccurances")
	public JSONSearchResponseDTO getOccurances(@RequestBody JSONSearchRequestDTO jsonSearchRequestDTO) {
		JSONSearchResponseDTO jsonSearchResponseDTO = new JSONSearchResponseDTO();
		List<JSONSearchResultDTO> searchResult = jsonSearchService.searchJSONForOccurance(jsonSearchRequestDTO.getJsonString(),
				jsonSearchRequestDTO.getSearchKey());
		jsonSearchResponseDTO.setNumberOfOccurances(Integer.toString(searchResult.size()));
		jsonSearchResponseDTO.setSearchResult(searchResult);
		return jsonSearchResponseDTO;
	}

}
